package com.itheima.dao;



import com.itheima.domain.Account;

import java.util.List;

public interface AccountMapper {
    public void save(Account account);
    public void delete(int id);
    public void update(Account account);
    public List<Account> findAll();
    public Account findOne(int id);
}
