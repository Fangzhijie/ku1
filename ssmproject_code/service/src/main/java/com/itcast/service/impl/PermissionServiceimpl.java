package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.Permissiondao;
import com.itcast.dao.Roledao;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.PermissionService;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceimpl implements PermissionService{
    @Autowired
    private Permissiondao permissiondao;

    @Override
    public List<Permission> findAllLimit(int page, int size) {
        PageHelper.startPage(page,size);
        List<Permission> all = permissiondao.findAll();
        return all;
    }

    @Override
    public List<Permission> findorleByIdAndAllRole(String id) {
        List<Permission> byroleid = permissiondao.findnotByroleid(id);
        return byroleid;
    }

    @Override
    public void savePermissionotoRole(String[] ids, String roleId) {
        for (String pid : ids) {
            permissiondao.savePermissionotoRole(pid,roleId);
        }
    }


    @Override
    public void save(Permission permission) {

        permissiondao.save(permission);
    }

}
