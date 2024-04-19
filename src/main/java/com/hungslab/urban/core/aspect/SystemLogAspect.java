package com.hungslab.urban.core.aspect;

import com.alibaba.fastjson.JSON;
import com.hungslab.urban.core.annotation.SystemLog;
import com.hungslab.urban.core.constant.SystemLogLevel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hungs
 * @date 2024-04-07
 * @Description
 */
@Aspect
@Component
public class SystemLogAspect {

    // @Before("execution(* com.hungslab.urban.service..*.*(..))") //前置通知
    // @AfterReturning("execution(* com.hungslab.urban.service.service..*.*(..))") //后置通知
    // 常见的是自定义注解实现切面编程。

    /**
     * 正常返回后通知：记录日志，日志内容为方法名称、方法的参数和返回值
     */
    @AfterReturning(pointcut = "@annotation(systemLog)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, SystemLog systemLog, Object result) {
        // 获取到logger
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        // 获取到方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取到方法的参数
        Object[] args = joinPoint.getArgs();

        // 获取日志级别
        SystemLogLevel level = systemLog.level();

        // 拼接日志内容
        String s = buildLogMessage(systemLog, result, methodName, args);

        // 根据日志级别记录日志
        switch (level) {
            case TRACE -> logger.trace(s);
            case DEBUG -> logger.debug(s);
            case INFO -> logger.info(s);
            case WARN -> logger.warn(s);
            case ERROR -> logger.error(s);
        }
    }

    /**
     * 抛出异常后通知：记录日志，日志内容为方法名称、方法的参数和异常信息
     */
    @AfterThrowing(pointcut = "@annotation(systemLog)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, SystemLog systemLog, Exception e) {
        // 获取到logger
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        // 获取到方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取到方法的参数
        Object[] args = joinPoint.getArgs();

        // 获取日志级别
        SystemLogLevel level = systemLog.level();

        // 拼接日志内容
        String s = buildLogMessage(systemLog, e, methodName, args);

        // 根据日志级别记录日志
        switch (level) {
            case TRACE -> logger.trace(s);
            case DEBUG -> logger.debug(s);
            case INFO -> logger.info(s);
            case WARN -> logger.warn(s);
            case ERROR -> logger.error(s);
        }
    }

    private static String buildLogMessage(SystemLog systemLog, Object result, String methodName, Object[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("调用方法：").append(methodName);
        if (systemLog.logParams()) {
            // 将参数转为JSON字符串
            String argsJson = JSON.toJSONString(args);
            sb.append("，参数：").append(argsJson);
        }
        if (systemLog.logResult()) {
            // 将Result转为JSON字符串
            String resultJson = JSON.toJSONString(result);
            sb.append("，返回值：").append(resultJson);
        }
        return sb.toString();
    }
}
