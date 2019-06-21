package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface RolesService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findRoleByIdAndPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissionId);
}
