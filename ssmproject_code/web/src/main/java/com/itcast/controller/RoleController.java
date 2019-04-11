package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Orders;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAllLimit")
    public String findAllLimit(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "3")Integer size, HttpServletRequest request){
        List<Role> all = roleService.findAllLimit(page,size);
        PageInfo<Role> RolePageInfo = new PageInfo<>(all);
        request.setAttribute("RolePageInfo",RolePageInfo);

        return "role-list";
    }
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id")String id, HttpServletRequest request){
        Role role=roleService.findById(id);
        request.setAttribute("Role",role);
        return "role-show";
    }
    @RequestMapping("/save")

    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAllLimit";
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id,HttpServletRequest request){
        List<Role> roles= roleService.findUserByIdAndAllRole(id);
        request.setAttribute("roleList",roles);
        request.setAttribute("user",id);
        return "user-role-add";
    }
    @RequestMapping("/saveall")
    public String saveall(String[] ids,String userId){
        String string = Arrays.toString(ids);
         roleService.saveRoletoUser(ids,userId);
        return "redirect:/user/findAllLimit";
    }
}
