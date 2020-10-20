package com.qfedu.service.intf;

import com.qfedu.dto.SmsRCodeDto;
import com.qfedu.vo.R;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 16:59
 * @Description:
 */
public interface SmslogService {
    //发送短信验证码
    R sendRCode(String phone);
    //短信验证码
    R checkRcode(SmsRCodeDto dto);
}
