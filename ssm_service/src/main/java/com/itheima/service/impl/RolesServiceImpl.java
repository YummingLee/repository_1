package com.itheima.service.impl;

import com.itheima.dao.RolesDao;
import com.itheima.domain.Role;
import com.itheima.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Role> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public void save(Role role) {
        rolesDao.save(role);
    }
}
