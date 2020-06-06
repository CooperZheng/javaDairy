package com.qianfeng.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequiresUser
    @RequestMapping("/query")
    public String queryOrder(){
        System.out.println("query Order");
        return "index";
    }
    @RequiresAuthentication
    @RequiresRoles(value = {"banzhang","student"},logical = Logical.OR)
    @RequestMapping("/save")
    public String saveOrder(){
        System.out.println("save Order");
        return "index";
    }

//    @RequiresPermissions("user:delete")
    @RequiresAuthentication
    @RequiresPermissions(value={"user:delete","user:query"},logical = Logical.AND)
    @RequestMapping("/delete")
    public String deleteOrder(){
        System.out.println("delete Order");
        return "index";
    }

    @RequiresAuthentication
    @RequestMapping("/update")
    public String updateOrder(){
        System.out.println("update Order");
        return "index";
    }
}
