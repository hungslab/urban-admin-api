package com.hungslab.urban.interceptor;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 拦截器注册
 */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {
    @Resource
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor).excludePathPatterns(
//                        "/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/v3/api-docs",
                        "/v3/api-docs/swagger-config",
                        "/swagger-ui/**",
                        "/system/user/login",
                        "/system/user/register");
    }
}