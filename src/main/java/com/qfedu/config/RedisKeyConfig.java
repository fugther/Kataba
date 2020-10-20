package com.qfedu.config;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:05
 * @Description:redis的各种key
 */
public class RedisKeyConfig {
    //注册验证码 String  有效期10
    public static final String SMS_RCODE="kataba:sms:rcode:";//后面追加手机号
    public static final int RCODE_TIME=600;//单位秒

    //存储令牌
    public static final String LOGIN_TOKEN="kataba:login:token:";//追加令牌

    public static final String LOGIN_USER="kataba:login:uid:";//追加用户id

    public static final int LOGIN_TIME=1800;//单位秒
}
