package com.mdxq.mall.user.dto;

import lombok.Data;

/**
 * 封装登录用户名和密码
 */
@Data
public class UserLoginDTO {
    private String username;
    private String password;
}
