package com.qfedu.util;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:40
 * @Description:
 */
public class StrUtil {
    /**
     * 校验是否为空
     * @param strs
     * @return true 非空 false 空
     */
    public static boolean checkNoEmpty(String... strs){
        boolean r=true;
        for (String s:strs){
            if (s==null||s.length()==0) {
                r=false;
                break;
            }
        }
        return r;
    }


}
