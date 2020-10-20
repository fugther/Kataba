package com.qfedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.dto.UserDto;
import com.qfedu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:31
 * @Description:基于mybatis-plus 实现持久层
 */
public interface UserDao extends BaseMapper<User> {

    @Select("select * from t_user where nickname=#{nname} or phone=#{phone}")
    @ResultType(User.class)
    User selectByNamePhone(@Param("nname") String nname,@Param("phone")  String phone);

    @Insert("insert into t_user(nickname,phone,password,flag) values(#{nname},#{phone},#{pwd},1)")
    int insertDto(UserDto dto);

    @Select("select * from t_user where nickname=#{name} or phone=#{name}")
    @ResultType(User.class)
    User selectByName(String name);
}
