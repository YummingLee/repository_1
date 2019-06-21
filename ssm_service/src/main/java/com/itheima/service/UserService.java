package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(String id);

    List<Role> findUserByIdAndAllRole(String userId);

    void addRoleToUser(String userId, String[] rolesId);
}
