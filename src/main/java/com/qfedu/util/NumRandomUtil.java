package com.qfedu.util;

import java.util.Random;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 17:30
 * @Description:生成随机数字
 */
public class NumRandomUtil {
    public static int randomNum(int len){
        Random random = new Random();

        //10的len-1次方
        double pow = Math.pow(10, len - 1);
        //随机返回0-bound之间的整数
        //包含0不包含bound
        return random.nextInt((int) (Math.pow(10,len)-pow)+(int) pow);
    }
}
