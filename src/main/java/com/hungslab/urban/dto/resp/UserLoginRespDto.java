package com.hungslab.urban.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户登录 响应DTO
 */
@Data
@Builder
public class UserLoginRespDto {

    private Long uid;

    private String username;

    private String token;
}
