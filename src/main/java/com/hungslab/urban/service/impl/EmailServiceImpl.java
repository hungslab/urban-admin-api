package com.hungslab.urban.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.EmailDetails;
import com.hungslab.urban.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * @author Hongs
 * @date 2024/3/25
 * @Description 邮箱服务类接口的实现
 */

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public AjaxResult sendTemplateMail(EmailDetails details)
    {
        // Try block to check for exceptions
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mailMessage, true);
            // 设置必要信息
            message.setFrom(sender);
            message.setSubject("西北民族大学实训测试");
            message.setTo(details.getRecipient());
            //获取验证码 存入redis
            int randomCode = RandomUtil.randomInt(10000, 99999);
            //邮箱发送内容组成
            message.setText(buildContent(Convert.toStr(randomCode)), true);

            javaMailSender.send(mailMessage);

            return AjaxResult.success("Mail Sent Successfully");
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 读取邮件模板
     * 替换模板中的信息
     *
     * @param title 内容
     * @return
     */
    public String buildContent(String title) {
        //加载邮件html模板
        Resource resource = new ClassPathResource("/templates/mailtemplate.ftl");
        InputStream inputStream = null;
        BufferedReader fileReader = null;
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            inputStream = resource.getInputStream();
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            log.info("发送邮件读取模板失败{}", e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //替换html模板中的参数
        return MessageFormat.format(buffer.toString(), title);
    }

}