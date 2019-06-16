package com.itheima.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page" ,defaultValue = "1") int page,@RequestParam(name = "size" , defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/orders-page-list");
        return mv;

    }

}
