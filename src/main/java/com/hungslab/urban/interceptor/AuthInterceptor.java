package com.hungslab.urban.interceptor;

import cn.hutool.core.convert.Convert;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungslab.urban.core.auth.UserHolder;
import com.hungslab.urban.core.exception.AuthorizationException;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.core.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Map;


/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 全局拦截器
 */
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取登录 JWT
        String token = request.getHeader("Authorization");
        // 开始认证
        try {
            if (!StringUtils.hasText(token)) {
                // token 为空
                throw new AuthorizationException("系统未登录");
            }
            // jwt解析
            Map<String, Object> claims = JwtUtils.parseToken(token);

            // 从redis中获取相同的token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken =  operations.get(Convert.toStr(Convert.toLong(claims.get("userid"))));

            if (redisToken == null) {
                // token生效
                throw new AuthorizationException("用户登录已过期");
            }
            // 把业务数据存储在ThreadLocal中
            UserHolder.set(claims);
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } catch (Exception e) {
            // 认证失败
            response.setStatus(401);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(
                    objectMapper.writeValueAsString(AjaxResult.error("用户未授权")));
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // 清理当前线程保存的用户数据
        UserHolder.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
