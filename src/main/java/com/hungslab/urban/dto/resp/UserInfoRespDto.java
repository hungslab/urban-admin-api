package com.hungslab.urban.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户信息响应DTO
 */
@Data
@Builder
public class UserInfoRespDto {

    /**
     * 昵称
     * */
    private String username;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phonenumber;

    /**
     * 用户头像
     * */
    private String avatar;

    /**
     * 用户性别
     * */
    private String userSex;
}
