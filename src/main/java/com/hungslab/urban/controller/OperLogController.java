package com.hungslab.urban.controller;

import com.hungslab.urban.core.annotation.OperationLogging;
import com.hungslab.urban.core.constant.OperLogType;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.OperationLog;
import com.hungslab.urban.service.OperationLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
@RestController
@CrossOrigin
@Tag(name = "日志管理相关接口")
@RequestMapping("/system/operlog")
public class OperLogController extends BaseController
{

    @Autowired
    private OperationLogService operationLogService;

    @PostMapping("/list")
    public AjaxResult list(@RequestBody OperationLog operationLog)
    {
        // startPage();
        List<OperationLog> list = operationLogService.selectOperationLogList(operationLog);
        return AjaxResult.success(list);
    }

    @OperationLogging(value= "操作日志", type = OperLogType.DELETE)
    @PostMapping("/remove")
    public AjaxResult remove(String ids)
    {
        return toAjax(operationLogService.deleteOperationLogByIds(ids));
    }

    @OperationLogging(value= "操作日志", type = OperLogType.DELETE)
    @PostMapping("/clean")
    public AjaxResult clean()
    {
        operationLogService.cleanOperationLog();
        return success();
    }
}
