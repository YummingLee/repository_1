package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RolesDao {
//    private String id;
//    private String roleName;
//    private String roleDesc;
//    private List<Permission> permissions;
//    private List<UserInfo> users;

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id" ,javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.PermissionsDao.findByRolesId"))
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(rolename,roledesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
