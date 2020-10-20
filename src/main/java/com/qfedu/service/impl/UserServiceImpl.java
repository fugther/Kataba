package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.config.RedisKeyConfig;
import com.qfedu.dao.UserDao;
import com.qfedu.dao.UserLogDao;
import com.qfedu.dto.UserDto;
import com.qfedu.dto.UserLoginDto;
import com.qfedu.entity.User;
import com.qfedu.entity.UserLog;
import com.qfedu.service.intf.UserService;
import com.qfedu.third.JedisUtil;
import com.qfedu.third.JwtUtil;
import com.qfedu.util.EncryptUtil;
import com.qfedu.util.StrUtil;
import com.qfedu.vo.R;
import io.jsonwebtoken.Jwt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private UserLogDao userLogDao;

    @Value("${kataba.passkey}")
    private String pk;

    @Override
    public R<List<User>> all() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        return R.ok(userDao.selectList(qw));
    }

    //校验手机号
    @Override
    public R checkPhone(String phone) {
        //检验手机号是否为空
        if (StrUtil.checkNoEmpty(phone)) {
            //查询phone
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("phone",phone);
            //校验是否存在
            if (userDao.selectOne(qw)!=null) {
                //存在，不可用
                return R.fail();
            }else {
                //不存咋，可用
                return R.ok();
            }
        }
        return R.fail();
    }

    //校验昵称
    @Override
    public R checkNickName(String name) {
        //检验昵称是否为空
        if (StrUtil.checkNoEmpty(name)) {
            //查询name
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("nickname",name);
            //校验昵称是否存在
            if (userDao.selectOne(qw)!=null) {
                //存在，不可用
                return R.fail();
            }else {
                //不存咋，可用
                return R.ok();
            }
        }
        return R.fail();
    }

    //注册(昵称,手机号,密码)
    @Override
    public R register(UserDto dto) {
        //校验昵称，手机号是否为空
        User user=userDao.selectByNamePhone(dto.getNname(),dto.getPhone());
        if (user==null) {
            //加密
            dto.setPwd(EncryptUtil.aesenc(pk,dto.getPwd()));
            //插入数据库
            User user1 = new User(dto.getPhone(), dto.getNname(), dto.getPwd(), 1);
            if (userDao.insert(user)>0) {
                //插入日志
                UserLog userLog = new UserLog(user.getId(), 1, "注册新用户", new Date());
                userLogDao.insert(userLog);
                return R.ok();
            }
        }
        return R.fail();
    }

    //登录(昵称或手机号,密码)
    @Override
    public R login(UserLoginDto loginDto) {
        //校验手机号或昵称
        User user=userDao.selectByName(loginDto.getName());
        if (user!=null) {
            //比较密码 密文比对
            if (EncryptUtil.aesenc(pk,loginDto.getPwd()).equals(user.getPassword())) {
                //密码一致
                //生成令牌
                String token = JwtUtil.createToken(user.getPhone());
                //储存令牌
                //记录令牌对应的用户信息
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_TOKEN+token,RedisKeyConfig.LOGIN_TIME,new JSONObject(user).toString());
                //记录登录过得账号信息
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_USER+user.getId(),RedisKeyConfig.LOGIN_TIME,token);
                return R.ok(token);
            }
        }
        return R.fail();
    }

    //找回密码(设置新密码)
    @Override
    public R findPass(UserDto dto) {
        return null;
    }
}
