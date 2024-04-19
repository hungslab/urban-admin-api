package com.hungslab.urban.core.auth;

import lombok.experimental.UtilityClass;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户信息持有类
 */
@UtilityClass
public class UserHolder {

    /**
     * 当前线程用户ID
     */
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }


    public static void clear() {
        THREAD_LOCAL.remove();
    }

}
