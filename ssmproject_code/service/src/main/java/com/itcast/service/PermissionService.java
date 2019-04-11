package com.itcast.service;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;

import java.util.List;

public interface PermissionService {
    void save(Permission permission);

    List<Permission> findAllLimit(int page, int size);

    List<Permission> findorleByIdAndAllRole(String id);

    void savePermissionotoRole(String[] ids, String roleId);
}
