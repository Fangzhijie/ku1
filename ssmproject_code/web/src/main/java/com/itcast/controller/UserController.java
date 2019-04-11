package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Product;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAllLimit")
    public ModelAndView findAllLimit(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "3")Integer size){
        List<UserInfo> all = userService.findAllLimit(page,size);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<UserInfo> UserPageInfo = new PageInfo<>(all);
        modelAndView.addObject("UserPageInfo",UserPageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/user/findAllLimit";

    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id,ModelAndView request){
        UserInfo byId = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user",byId);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

}
