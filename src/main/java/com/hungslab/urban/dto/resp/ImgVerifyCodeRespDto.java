package com.hungslab.urban.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 图像验证码 响应DTO
 */
@Data
@Builder
public class ImgVerifyCodeRespDto {

    /**
     * 当前会话ID，用于标识改图形验证码属于哪个会话
     * */
    private String sessionId;

    /**
     * Base64 编码的验证码图片
     * */
    private String img;

}
