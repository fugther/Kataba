package com.qfedu.vo;

import com.qfedu.core.type.RType;
import lombok.Data;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:45
 * @Description:统一返回值
 */
@Data
public class R<T> {
    private int code;//返回码
    private String msg;//返回码的字符串信息
    private T data;//返回的数据

    public static <T> R setR(int c,String m,T obj){
        R r=new R();
        r.setCode(c);
        r.setMsg(m);
        r.setData(obj);
        return r;
    }
    //成功
    public static R ok(){
        return setR(RType.成功.getVal(),"OK",null);
    }
    //成功
    public static <T> R ok(T t){
        return setR(RType.成功.getVal(),"OK",t);
    }
    //失败
    public static R fail(){
        return setR(RType.失败.getVal(),"Fail",null);
    }
}
