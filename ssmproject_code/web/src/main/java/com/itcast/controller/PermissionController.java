package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAllLimit")
    public String findAllLimit(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "3")Integer size, HttpServletRequest request){
        List<Permission> all = permissionService.findAllLimit(page,size);
        PageInfo<Permission> permissionPageInfo = new PageInfo<>(all);
        request.setAttribute("PermissionPageInfo",permissionPageInfo);
        System.out.println(permissionPageInfo);
        return "permission-list";
    }

    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission/findAllLimit";
    }


    @RequestMapping("/findRoleByIdAndAllRole")
    public String findRoleByIdAndAllRole(String id,HttpServletRequest request){
        List<Permission> permissionList= permissionService.findorleByIdAndAllRole(id);
        request.setAttribute("permissionList",permissionList);
        request.setAttribute("role",id);
        return "role-permission-add";
    }
    @RequestMapping("/saveall")
    public String saveall(String[] ids,String roleId){
        String string = Arrays.toString(ids);
        permissionService.savePermissionotoRole(ids,roleId);
        return "redirect:/user/findAllLimit";
    }
}
