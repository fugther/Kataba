package com.qfedu.service.impl;

import com.qfedu.config.RedisKeyConfig;
import com.qfedu.dao.SmslogDao;
import com.qfedu.dto.SmsRCodeDto;
import com.qfedu.service.intf.SmslogService;
import com.qfedu.third.JedisUtil;
import com.qfedu.third.SmsUtil;
import com.qfedu.util.NumRandomUtil;
import com.qfedu.util.StrUtil;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 17:07
 * @Description:
 */
@Service
public class SmslogServiceImpl implements SmslogService {
    @Autowired
    private SmslogDao smslogDao;

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @Override
    public R sendRCode(String phone) {
        //生成6位验证码
        int i = NumRandomUtil.randomNum(6);
        //发送验证码
        if (SmsUtil.sendRCode(phone,i)) {
           //存储验证码
            JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.SMS_RCODE+phone,RedisKeyConfig.RCODE_TIME,i+"");
            //结果返回
            return R.ok();
        }
        return R.fail();
    }

    /**
     * 校验短信验证码
     * @param dto
     * @return
     */
    @Override
    public R checkRcode(SmsRCodeDto dto) {
        //校验手机号是否为空
        if (StrUtil.checkNoEmpty(dto.getPhone())) {
            //验证码
            String k=RedisKeyConfig.SMS_RCODE+dto.getPhone();
            //校验验证码是否失效
            if (JedisUtil.getInstance().getJedis().exists(k)) {
                //校验验证码是否一致
                if (dto.getCode()==Integer.parseInt(JedisUtil.getInstance().STRINGS.get(k))) {
                    return R.ok();
                }
            }
        }
        return R.fail();
    }
}
