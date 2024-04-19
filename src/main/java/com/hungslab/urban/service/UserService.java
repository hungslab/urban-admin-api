package com.hungslab.urban.service;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.dto.req.UserRegisterReqDto;
import com.hungslab.urban.pojo.User;

import java.util.List;

/**
 * @author admin
 * @date 2024/3/25
 * @Description Description of the file.
 */
public interface UserService {

    /**
     * 注册账号
     * @param dto
     * @return
     */
    AjaxResult registAccount(UserRegisterReqDto dto);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    AjaxResult loginAccount(String username, String password);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    AjaxResult userInfo(String token);

    /**
     * 用户注销
     * @return
     */
    AjaxResult logout();

    /**
     *
     */
    AjaxResult list(User dto);

    /**
     * 更新用户
     * @param dto
     * @return
     */
    int updateUser(User dto);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    AjaxResult deleteRoleById(Long userId);

    /**
     * 重置用户密码
     * @param dto
     * @return
     */
    AjaxResult resetUserPwd(User dto);

    /**
     * 校验用户名称是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean checkUserNameUnique(User user);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean checkPhoneUnique(User user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean checkEmailUnique(User user);

    public int insertUser(User user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public User selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    public User selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    public User selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

}
