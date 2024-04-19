package com.hungslab.urban.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hungs
 * @date 2024-04-07
 * @Description 自定义业务异常，用于处理用户请求时，业务错误时抛出
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationException extends RuntimeException {
    private final String errorAuth;

    public AuthorizationException(String errorAuth) {
        // 不调用父类 Throwable的fillInStackTrace() 方法生成栈追踪信息，提高应用性能
        // 构造器之间的调用必须在第一行
        super(errorAuth, null, false, false);
        this.errorAuth = errorAuth;
    }
}
