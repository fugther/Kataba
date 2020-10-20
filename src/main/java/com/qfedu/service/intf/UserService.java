package com.qfedu.service.intf;

import com.qfedu.dto.UserDto;
import com.qfedu.dto.UserLoginDto;
import com.qfedu.entity.User;
import com.qfedu.vo.R;

import java.util.List;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:37
 * @Description:
 */
public interface UserService {
    R<List<User>> all();

    //校验手机号
    R checkPhone(String phone);
    //校验昵称
    R checkNickName(String name);
    //注册(昵称,手机号,密码)
    R register(UserDto dto);
    //登录(昵称或手机号,密码)
    R login(UserLoginDto loginDto);
    //找回密码(设置新密码)
    R findPass(UserDto dto);
}
