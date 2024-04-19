package com.hungslab.urban.core.annotation;

import com.hungslab.urban.core.constant.OperLogType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description 记录操作日志
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OperationLogging {

    /**
     * 操作内容描述
     */
    String value() default "";

    /**
     * 操作类型
     */
    OperLogType type() default OperLogType.OTHER;


}