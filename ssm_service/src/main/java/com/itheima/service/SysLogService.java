package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogService {
    List<SysLog> findAll();

    void save(SysLog sysLog);
}
