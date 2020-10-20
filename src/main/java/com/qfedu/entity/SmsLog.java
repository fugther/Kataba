package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 16:56
 * @Description:短信发送表
 */
@Data
@TableName("t_smslog")
public class SmsLog {
    @TableId(type = IdType.AUTO)
    private int id;
    private String phone;
    private int type;
    private String content;
    private Date ctime;
}
