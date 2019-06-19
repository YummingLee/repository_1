package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RolesService {
    List<Role> findAll();

    void save(Role role);
}
