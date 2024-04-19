package com.hungslab.urban.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户注册 响应DTO
 */
@Data
@Builder
public class UserRegisterRespDto {

    private Long uid;

    private String token;
}
