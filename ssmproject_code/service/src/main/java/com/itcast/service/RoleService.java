package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findByUserid(String userid);
    List<Role> findAll();

    List<Role> findAllLimit(int page, int size);

    Role findById(String id);

    void save(Role role);

    List<Role> findUserByIdAndAllRole(String id);



    void saveRoletoUser(String[] ids, String userid);
}
