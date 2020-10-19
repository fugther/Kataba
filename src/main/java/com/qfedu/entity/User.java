package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:16
 * @Description:
 */
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String phone;
    private String nickname;
    private String password;
    private int flag;//标记位 1有效2无效
}
