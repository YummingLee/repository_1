package com.itheima.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/save",produces = "text/html;charset=utf-8")
    public String save(Account account){
        accountService.save(account);
        return "redirect:/list.jsp";
    }


    @RequestMapping("/delete")
    public String delete(Account account){
        int id = account.getId();
        accountService.delete(id);

        return "redirect:/list.jsp";
    }

    @RequestMapping("/findOne")
    public String findOne(int id, HttpSession session){
        Account account = accountService.findOne(id);
//        System.out.println("存的:"+account);
        session.setAttribute("account",account);
        return  "/update";
    }

    @RequestMapping("/update")
    public String update(Account account,HttpSession session){
//        System.out.println("获取"+account);
        accountService.update(account);

        return "redirect:/list.jsp";
    }

    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAll() throws JsonProcessingException {
        List<Account> list = accountService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);

        return json;
    }



}
