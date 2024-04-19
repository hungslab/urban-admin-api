package com.hungslab.urban.core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description JWT工具集
 */
@Slf4j
public class JwtUtils {

    /**
     * 注入JWT加密密钥
     */
    private static final String secret = "E66559580A1ADF48CDD928516062F12E";


    /**
     * 过期时间(单位:秒)
     */
    private static final long EXPIRATION_TIME = 86400000; // 24 hours in milliseconds

    /**
     * 根据用户ID生成JWT
     *
     * @param claims    用户信息
     * @return JWT
     */
    public static String generateToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证Token
     * @param token
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    /**
     * 解析JWT返回用户ID
     *
     * @param token     JWT
     * @return 用户ID
     */
    public static Map<String, Object> parseToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getClaim("claims")
                    .asMap();
        } catch (JWTDecodeException e) {
            log.warn("JWT解析失败:{}", token);
            throw  e;
        }
    }
}
