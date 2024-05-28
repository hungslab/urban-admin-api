package com.hungslab.urban.core.utils;


import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hungs
 * @date 2024-04-28
 * @Description
 */
@Configuration
public class SpringSensitiveWordConfig {
    /**
     * 初始化引导类
     *
     * @return 初始化引导类
     * @since 1.0.0
     */
    @Bean
    public SensitiveWordBs sensitiveWordBs() {
        // 可根据数据库数据判断 动态增加配置
        return SensitiveWordBs.newInstance()
                .wordDeny(WordDenys.chains(WordDenys.system())) // 设置黑名单
                .wordAllow(WordAllows.chains(WordAllows.system())) // 设置白名单
                // 各种其他配置
                .init();
    }

}

