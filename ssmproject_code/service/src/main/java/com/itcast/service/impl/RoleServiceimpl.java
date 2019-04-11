package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.Roledao;
import com.itcast.dao.Userdao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceimpl implements RoleService{
    @Autowired
    private Roledao roledao;
    @Autowired
    private Userdao userdao;
    @Override
    public List<Role> findByUserid(String userid) {
        List<Role> byUserid = roledao.findByUserid(userid);
        return byUserid;
    }

    @Override
    public List<Role> findAll() {
        List<Role> all = roledao.findAll();
        return all;
    }

    @Override
    public List<Role> findAllLimit(int page, int size) {
        PageHelper.startPage(page,size);
        List<Role> all = roledao.findAll();
        return all;
    }

    @Override
    public Role findById(String id) {
        Role byid = roledao.findByid(id);
        return byid;
    }

    @Override
    public void save(Role role) {
        roledao.save(role);
    }
    @Override
    public List<Role> findUserByIdAndAllRole(String userid) {
        List<Role> roles = roledao.findnotByid(userid);
             return roles;
    }

    @Override
    public void saveRoletoUser(String[] ids, String userid) {
        for (String orleid : ids) {
               roledao.saveRoletoUser(userid,orleid);
        }
    }


}
