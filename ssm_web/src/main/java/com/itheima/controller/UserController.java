package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session){
        ModelAndView mv = new ModelAndView();
        User loginUser = userService.login(user);

        if(loginUser == null){
            mv.addObject("msg","用户名/密码错误");
            mv.setViewName("/login");

        }else{
            session.setAttribute("user",loginUser);
            mv.setViewName("redirect:/list.jsp");
        }
        return mv;
    }

}
