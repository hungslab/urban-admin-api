package com.hungslab.urban.core.utils;

import cn.hutool.core.convert.Convert;
import com.hungslab.urban.core.auth.UserHolder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
@Component
public class SecurityUtils {

    /**
     * 获取登录用户id
     */
    public static Long getUserId()
    {
        Map<String, Object> map =  UserHolder.get();
        return Convert.toLong(map.get("userid"));
    }

    /**
     * 获取登录用户名
     */
    public static String getLoginName()
    {
        Map<String, Object> map =  UserHolder.get();
        return (String) map.get("username");
    }


}
