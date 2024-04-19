package com.hungslab.urban.core.annotation;

import com.hungslab.urban.core.constant.SystemLogLevel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hungs
 * @date 2024-04-07
 * @Description 用在Controller的方法上，表示该方法需要记录日志，日志内容为方法名称、方法的参数和返回值
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({java.lang.annotation.ElementType.METHOD})
public @interface SystemLog {

    SystemLogLevel level() default SystemLogLevel.INFO;

    boolean logParams() default true;

    boolean logResult() default true;

    boolean logException() default true;
}