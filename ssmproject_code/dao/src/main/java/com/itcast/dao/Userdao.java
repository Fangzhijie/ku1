package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Userdao {
    List<UserInfo> findAll();
    UserInfo findByUsername(String username);
    UserInfo findByid(String id);
    void addRoleToUser(@Param("id") String id, @Param("rolesid") String rolesid);
    void save(UserInfo userInfo);
    @Select("select * from users where id in(select userid from users_role where roleid=#{roleid}) ")
    List<UserInfo> findByroleid(String roleid);


}
