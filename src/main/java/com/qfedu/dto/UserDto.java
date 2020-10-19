package com.qfedu.dto;

import lombok.Data;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:33
 * @Description:
 */
@Data
public class UserDto {
    private String phone;
    private String nname;//昵称
    private String pwd;//密码
}
