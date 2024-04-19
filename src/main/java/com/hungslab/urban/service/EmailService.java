package com.hungslab.urban.service;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.EmailDetails;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 邮箱服务类，具体邮箱发送的接口定义
 */

// Interface
public interface EmailService {

    /**
     * 发送模板html邮件
     * @param details
     * @return
     */
    AjaxResult sendTemplateMail(EmailDetails details);

    // Method
    // To send an email with attachment
    // String sendMailWithAttachment(EmailDetails details);

    public String buildContent(String title);
}

