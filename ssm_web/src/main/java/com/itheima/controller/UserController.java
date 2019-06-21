package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired()
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("/user-list");

       return  mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo user){
        userService.save(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("/user-show");

        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id") String userId){
        ModelAndView mv = new ModelAndView();
        List<Role> list = userService.findUserByIdAndAllRole(userId);
        UserInfo userInfo = userService.findById(userId);
        mv.addObject("roleList",list);
        mv.addObject("user",userInfo);
        mv.setViewName("/user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId") String userId,@RequestParam(name = "ids") String[] rolesId){

        userService.addRoleToUser(userId,rolesId);
        return "redirect:/user/findAll";
    }

}
