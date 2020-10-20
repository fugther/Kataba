package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 9:17
 * @Description:用户日志表
 */
@Data
@TableName("t_userlog")
public class UserLog {
    @TableId(type = IdType.AUTO)
    private int id;
    private int uid;
    private int type;
    private String content;
    private Date ctime;

    public UserLog(int uid, int type, String content, Date ctime) {
        this.uid = uid;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }
}
