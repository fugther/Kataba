package com.qfedu;

import com.qfedu.util.EncryptUtil;
import org.junit.jupiter.api.Test;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 21:20
 * @Description:测试生成秘钥
 */
public class Pass_Test {
    @Test
    public void t1(){
        //生成秘钥
        String aesKey = EncryptUtil.createAESKey();
        System.out.println("aesKey = " + aesKey);
        //密码
        String pass="123456";
        //加密
        String aesenc = EncryptUtil.aesenc(aesKey, pass);
        System.out.println("aesenc = " + aesenc);
        //解密
        System.out.println(EncryptUtil.aesdec(aesKey,aesenc));
    }
}
