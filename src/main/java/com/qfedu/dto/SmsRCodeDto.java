package com.qfedu.dto;

import lombok.Data;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 17:01
 * @Description:
 */
@Data
public class SmsRCodeDto {
    private String phone;
    private int code;
}
