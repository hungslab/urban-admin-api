package com.hungslab.urban.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 用户注册请求DTO
 */
@Data
public class UserRegisterReqDto {

    @NotBlank(message="用户名不能为空！")
    private String username;

    @NotBlank(message="密码不能为空！")
    private String password;


}
