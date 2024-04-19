package com.hungslab.urban.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.hungslab.urban.mapper.UserMapper;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.core.utils.JwtUtils;
import com.hungslab.urban.core.utils.SecurityUtils;
import com.hungslab.urban.dto.req.UserRegisterReqDto;
import com.hungslab.urban.dto.resp.UserInfoRespDto;
import com.hungslab.urban.dto.resp.UserLoginRespDto;
import com.hungslab.urban.pojo.User;
import com.hungslab.urban.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.hungslab.urban.core.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description Description of the file.
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 用户注册
     * @param dto
     * @return
     */
    @Override
    public AjaxResult registAccount(UserRegisterReqDto dto) {
        String username = dto.getUsername(), password = dto.getPassword();
        if (StringUtils.isEmpty(username))
        {
            return AjaxResult.warn("用户名不能为空");
        }
        else if (StringUtils.isEmpty(password))
        {
            return AjaxResult.warn("用户密码不能为空");
        }
        else if (Objects.isNull(userMapper.checkUserNameUnique(username)))
        {
            return AjaxResult.warn("保存用户'" + username + "'失败，注册账号已存在");
        }
        else
        {
            // 注册成功，保存用户信息
            User user = new User();
            String salt = RandomUtil.randomNumbers(4);
            user.setSalt(salt);
            user.setPassword(
                    SecureUtil.md5(username + password + salt));
            user.setUserName(username);
            user.setCreateTime(DateTime.now());
            user.setUpdateTime(DateTime.now());
            userMapper.insertUser(user);
            return AjaxResult.success("注册成功");
        }
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public AjaxResult loginAccount(String username, String password) {
        User loginuser = userMapper.selectUserByUserName(username);

        if (Objects.isNull(loginuser)) {
            return AjaxResult.warn("用户名不存在");
        }

        if (!SecureUtil.md5(username + password + loginuser.getSalt()).equals(loginuser.getPassword())) {
            return AjaxResult.warn("密码错误");
        }
        else {
            Map<String, Object> claims = new HashMap<>();
            claims.put("userid", loginuser.getUserId());
            claims.put("username", loginuser.getUserName());
            String token = JwtUtils.generateToken(claims);

            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(Convert.toStr(loginuser.getUserId()), token,1, TimeUnit.HOURS);

            // 登录成功，生成JWT并返回
            return AjaxResult.success(UserLoginRespDto.builder()
                    .token(token)
                    .uid(loginuser.getUserId())
                    .username(loginuser.getUserName()).build());
        }
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @Override
    public AjaxResult userInfo(String token) {
        Map<String, Object> claims = JwtUtils.parseToken(token);
        Long userid = Convert.toLong(claims.get("userid"));
        User user = userMapper.selectUserById(userid);
        return AjaxResult.success(UserInfoRespDto.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .phonenumber(user.getPhonenumber())
                .userSex(user.getSex())
                .avatar(user.getAvatar()).build());
    }


    /**
     * 更新用户信息
     * @param dto
     * @return
     */
    @Override
    public int updateUser(User dto) {
        return userMapper.updateUser(dto);
    }

    @Override
    public AjaxResult logout() {
        //删除redis中对应的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(Convert.toStr(SecurityUtils.getUserId()));
        return AjaxResult.success();
    }

    @Override
    public AjaxResult list(User dto) {
        // startPage();
        List<User> list = userMapper.selectUserList(dto);
        return AjaxResult.success(list);
    }

    /**
     * 更新用户密码
     * @param dto
     * @return
     */
    @Override
    public AjaxResult resetUserPwd(User dto)
    {
        User user = userMapper.selectUserById(dto.getUserId());
        user.setSalt(Convert.toStr(RandomUtil.randomInt(1111, 9999)));
        user.setPassword(SecureUtil.md5(dto.getUserName() + dto.getPassword() + dto.getSalt()));
        userMapper.updateUser(user);
        //删除redis中对应的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(Convert.toStr(user.getUserId()));
        return AjaxResult.success();
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Override
    public AjaxResult deleteRoleById(Long userId) {
        if (Objects.isNull(userMapper.selectUserById(userId))) {
            return AjaxResult.error("此用户不存在");
        }
        userMapper.deleteUserById(userId);
        //删除redis中对应的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(Convert.toStr(userId));
        return AjaxResult.success();
    }


    /**
     * 校验用户名称是否与userid一致
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean checkUserNameUnique(User user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkUserNameUnique(user.getUserName());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return false;
        }
        return true;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkPhoneUnique(User user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return false;
        }
        return true;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkEmailUnique(User user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return false;
        }
        return true;
    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(User user)
    {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        return rows;
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public User selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public User selectUserByLoginName(String userName)
    {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    @Override
    public User selectUserByPhoneNumber(String phoneNumber)
    {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public User selectUserByEmail(String email)
    {
        return userMapper.selectUserByEmail(email);
    }



}
