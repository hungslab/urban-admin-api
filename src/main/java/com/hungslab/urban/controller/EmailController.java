package com.hungslab.urban.controller;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.EmailDetails;
import com.hungslab.urban.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description  邮箱相关 API 管理器
 */
@RestController
@Tag(name = "邮件管理相关接口")
@RequestMapping("/system/review")
public class EmailController extends BaseController {

    @Autowired
    private EmailService emailService;

    /**
     * 发送邮件
     * @param details
     * @return
     */
    @Operation(summary = "发送邮件接口")
    @PostMapping("/api/sendmail")
    public AjaxResult sendMail(@RequestParam("mail") EmailDetails details)
    {
        return emailService.sendTemplateMail(details);
    }

}
