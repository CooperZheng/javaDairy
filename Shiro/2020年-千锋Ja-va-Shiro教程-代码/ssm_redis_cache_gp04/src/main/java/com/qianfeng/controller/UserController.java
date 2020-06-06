package com.qianfeng.controller;

import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author 臧红久
 * @Date 2019/10/15
 * @Version V1.0
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("users")
    public String queryAllUsers(Model model){
        List<User> users = userService.selectAllUsers();
        model.addAttribute("users",users);
        return "forward:/WEB-INF/users.jsp";
    }

    @PostMapping("regist")
    public String saveUser(User user){
        userService.insertUser(user);
        return "redirect:/users";
    }

    @GetMapping("regist")
    public String registPage(){
        return "forward:/WEB-INF/regist.jsp";
    }

    @GetMapping("login")
    public String login(){
        System.out.println("goto login page");
        return "forward:/WEB-INF/login.jsp";
    }

    @PostMapping("login")
    public String loginLogic(User user){
        System.out.println("lgoin logic");
        // 登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        SecurityUtils.getSubject().login(token);
        return "redirect:/users";
    }

    /**
     * 登出： 清除 cookie  session  缓存
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "index";
    }
}
