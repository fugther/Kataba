package com.qfedu.core.type;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:11
 * @Description: 枚举类型 或者用常量代替
 */
public enum  RType {
    成功(1),失败(2),登陆失败(3);
    private int val;

    public int getVal() {
        return val;
    }

    private RType(int v) {
        val = v;
    }
}
