package com.qfedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:31
 * @Description:基于mybatis-plus 实现持久层
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
