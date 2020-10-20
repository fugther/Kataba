package com.qfedu.dto;

import lombok.Data;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 16:49
 * @Description:
 */
@Data
public class UserLoginDto {
    private String name;//可能是手机或昵称
    private String pwd;
}
