package com.itheima.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(@RequestParam(name = "page" ,defaultValue = "1") int page,@RequestParam(name = "size" ,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll(page,size);
        PageInfo<Product> pi = new PageInfo<Product>(list);
        mv.addObject("pageInfo" ,pi);
        mv.setViewName("/product-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){

        productService.save(product);
        return "/product/findAll";
    }
}
