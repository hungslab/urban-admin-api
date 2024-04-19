package com.hungslab.urban.core.aspect;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;
import com.hungslab.urban.core.annotation.OperationLogging;
import com.hungslab.urban.core.utils.IpUtils;
import com.hungslab.urban.core.utils.SecurityUtils;
import com.hungslab.urban.core.utils.ServletUtils;
import com.hungslab.urban.pojo.OperationLog;
import com.hungslab.urban.service.OperationLogService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
@Aspect
@Component
@RequiredArgsConstructor
public class OperationLogAspect {

    @Resource
    private OperationLogService operationLogService;

    @AfterReturning(pointcut = "@annotation(operationLogging)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, OperationLogging operationLogging, Object result) {
        String resultStr = JSON.toJSONString(result);
        buildAndSaveLog(joinPoint, operationLogging, resultStr);
    }

    @AfterThrowing(pointcut = "@annotation(operationLogging)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, OperationLogging operationLogging, Exception e) {
        String resultStr = e.getMessage();
        // 保留前2000个字符
        if (resultStr.length() > 2000) {
            resultStr = resultStr.substring(0, 2000);
        }
        buildAndSaveLog(joinPoint, operationLogging, resultStr);
    }

    @Transactional(rollbackFor = Exception.class)
    public void buildAndSaveLog(JoinPoint joinPoint, OperationLogging operationLogging, String resultStr) {
        OperationLog operationLog = new OperationLog();
        operationLog.setDescription(operationLogging.value());

        operationLog.setMethod(joinPoint.getSignature().getName());
        operationLog.setOperatorType(operationLogging.type().ordinal());
        operationLog.setOperParam(JSON.toJSONString(joinPoint.getArgs()));
        operationLog.setJsonResult(resultStr);
        operationLog.setOperIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        operationLog.setOperTime(DateTime.now());

        operationLog.setOperName(SecurityUtils.getLoginName());
        operationLogService.insertOperationLog(operationLog);
    }
}