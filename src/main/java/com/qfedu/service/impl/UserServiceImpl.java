package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.intf.UserService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:37
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public R<List<User>> all() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        return R.ok(userDao.selectList(qw));
    }
}
