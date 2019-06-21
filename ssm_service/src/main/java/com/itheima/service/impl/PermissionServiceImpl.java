package com.itheima.service.impl;

import com.itheima.dao.PermissionsDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

   @Autowired
    private PermissionsDao permissionsDao;

    @Override
    public List<Permission> findAll() {
        return  permissionsDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionsDao.save(permission);
    }

    @Override
    public Permission findById(String permissionId) {
        return permissionsDao.findById(permissionId);
    }
}
