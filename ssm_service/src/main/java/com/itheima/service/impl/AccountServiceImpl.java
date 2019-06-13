package com.itheima.service.impl;


import com.itheima.dao.AccountMapper;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public void delete(int id) {
        accountMapper.delete(id);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public List<Account> findAll() {
        return  accountMapper.findAll();
    }

    @Override
    public Account findOne(int id) {
        return  accountMapper.findOne(id);
    }
}
