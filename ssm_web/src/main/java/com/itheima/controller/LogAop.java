package com.itheima.controller;


import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
public class LogAop {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private SysLogService sysLogService;

    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object recordLog(ProceedingJoinPoint pjp) throws Throwable {

        SysLog sysLog = new SysLog();
        //访问时间
        long visitTime = System.currentTimeMillis();
        sysLog.setVisitTime(new Date(visitTime));
        //用户名
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLog.setUsername(user.getUsername());
        //访问ip
        String ip = httpServletRequest.getRemoteAddr();
        sysLog.setIp(ip);
        //访问url
        String uri = httpServletRequest.getRequestURI();
        sysLog.setUrl(uri);
        //执行时长
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        sysLog.setExecutionTime(endTime-visitTime);
        //访问方法
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        sysLog.setMethod("[类名] ："+className+"[方法名] ："+methodName);

        sysLogService.save(sysLog);

        return proceed;

    }


}


