package com.itcast.dao;

import com.itcast.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Permissiondao {
    @Select("select * from Permission where id in (select permissionid from role_permission where roleid=#{roleid})")
    List<Permission> findByroleid(String roleid);
    @Select("select * from Permission")
    List<Permission> findAll();
    @Select("insert into permission (permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission);
    @Select("select * from Permission where id not in (select permissionid from role_permission where roleid=#{roleid})")
    List<Permission> findnotByroleid(String id);
    void save(@Param("userid")String userid, @Param("roleid")String orleid);
    void savePermissionotoRole(@Param("pid") String pid,@Param("roleId") String roleId);
}
