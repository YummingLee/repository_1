package com.itheima.controller;


import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> list =  rolesService.findAll();
        mv.addObject("roleList",list);
        mv.setViewName("/role-list");

        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role){
        rolesService.save(role);
        return "redirect:/role/findAll";
    }


    @RequestMapping("/findRoleByIdAndPermission")
    public ModelAndView findRoleByIdAndPermission(@RequestParam(name = "id") String roleId){
        ModelAndView mv = new ModelAndView();
        List<Permission> list = rolesService.findRoleByIdAndPermission(roleId);
        Role role = rolesService.findById(roleId);
        mv.addObject("permissionList",list);
        mv.addObject("role",role);
        mv.setViewName("/role-permission-add");

        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionId){
        rolesService.addPermissionToRole(roleId,permissionId);
        return "redirect:/role/findAll";

    }
}
