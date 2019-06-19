package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDao {
//    private String id;
//    private String username;
//    private String email;
//    private String password;
//    private String phoneNum;
//    private int status;
//    private String statusStr;
//    private List<Role> roles;

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,javaType =java.util.List.class,many = @Many(select = "com.itheima.dao.RolesDao.findRoleByUserId"))
    })
    public UserInfo findByUserName(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(username,password,email,phoneNum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo user);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,javaType =java.util.List.class,many = @Many(select = "com.itheima.dao.RolesDao.findRoleByUserId"))
    })
    UserInfo findById(String id);
}
