package com.qfedu.controller;

import com.qfedu.dto.SmsRCodeDto;
import com.qfedu.service.intf.SmslogService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 16:53
 * @Description:
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmslogService smslogService;

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @PostMapping("/sendrcode/{phone}")
    public R sendRCode(@PathVariable String phone){
        return smslogService.sendRCode(phone);
    }

    /**
     * 校验短信验证码
     * @param dto
     * @return
     */
    @PostMapping("/checkrcode")
    public R checkRCode(SmsRCodeDto dto){
        return smslogService.checkRcode(dto);
    }
}
