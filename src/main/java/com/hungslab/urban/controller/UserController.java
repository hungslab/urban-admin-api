package com.hungslab.urban.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.hungslab.urban.core.annotation.OperationLogging;
import com.hungslab.urban.core.constant.OperLogType;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.core.utils.SecurityUtils;
import com.hungslab.urban.core.utils.StringUtils;
import com.hungslab.urban.dto.req.UserRegisterReqDto;
import com.hungslab.urban.pojo.User;
import com.hungslab.urban.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户相关 API 管理器
 */
@RestController
@CrossOrigin
@Tag(name = "用户管理相关接口")
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Operation(summary = "用户登录接口")
    @PostMapping("/login")
    public AjaxResult loginAccount(String username, String password) {
        return userService.loginAccount(username, password);
    }

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @Operation(summary = "用户注册接口")
    @PostMapping("/register")
    public AjaxResult registAccount(@RequestBody @Validated UserRegisterReqDto dto) {
        return userService.registAccount(dto);
    }

    /**
     * 获取用户信息
     */
    @Operation(summary = "用户信息查询接口")
    @GetMapping("/info")
    public AjaxResult userInfo(@Parameter(description = "用户token") String token) {
        return userService.userInfo(token);
    }

    /**
     * 用户登出
     * @return
     */
    @Operation(summary = "用户登出接口")
    @GetMapping("/logout")
    public AjaxResult logout() {
        return userService.logout();
    }

    /**
     * 管理员重置用户密码
     */
    @Operation(summary = "管理员重置密码")
    @OperationLogging(value = "重置用户密码", type = OperLogType.UPDATE)
    @PutMapping("/resetpwd")
    public AjaxResult resetUserPwd(@RequestBody @Validated User dto) {
        return userService.resetUserPwd(dto);
    }

    /**
     * 管理员用户列表
     */
    @Operation(summary = "获取用户列表接口")
    @PostMapping("/list")
    public AjaxResult list(@RequestBody User dto){

        return userService.list(dto);
    }

    /**
     * 管理员删除用户
     */
    @Operation(summary = "用户删除接口")
    @OperationLogging(value = "删除用户", type = OperLogType.DELETE)
    @DeleteMapping("/delete")
    public AjaxResult remove(@Parameter(description = "用户ID") Long userId)
    {
        return userService.deleteRoleById(userId);
    }

    /**
     * 管理员新增用户
     */
    @Operation(summary = "新增用户接口")
    @PostMapping("/add")
    @OperationLogging(value = "新增用户", type = OperLogType.INSERT)
    public AjaxResult addSave(@RequestBody @Validated User user)
    {
        if (!userService.checkUserNameUnique(user))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setSalt(Convert.toStr(RandomUtil.randomInt(1000, 9999)));
        user.setPassword(SecureUtil.md5(user.getUserName() + user.getPassword() + user.getSalt()));
        user.setCreateBy(SecurityUtils.getLoginName());
        return toAjax(userService.insertUser(user));
    }

    /**
     * 管理员修改用户信息
     */
    @Operation(summary = "更新用户信息接口")
    @OperationLogging(value = "修改用户信息", type = OperLogType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@Validated User user)
    {
        if (!userService.checkUserNameUnique(user))
        {
            return error("修改用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        user.setUpdateBy(SecurityUtils.getLoginName());
        // redis清除用户登录状态

        return toAjax(userService.updateUser(user));
    }
}
