package com.itcast.dao;

import com.itcast.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Roledao {
   List<Role> findByUserid(String userid);
   @Select("select * from Role")
   @Results({
           @Result(id = true,property ="id",column ="id"),
           @Result(property = "permissions",column ="id",many =@Many(select ="com.itcast.dao.Permissiondao.findByroleid")),
           @Result( property ="users",column ="id",many =@Many(select ="com.itcast.dao.Userdao.findByroleid"))
   })
    List<Role> findAll();
    @Select("select * from Role where id=#{id}")
    @Results({
            @Result(id = true,property ="id",column = "id"),
            @Result(property = "permissions",column = "id",many =@Many(select ="com.itcast.dao.Permissiondao.findByroleid")),
            @Result( property ="users",column ="id",many =@Many(select ="com.itcast.dao.Userdao.findByroleid"))
    })
    Role findByid(String id);
    @Insert("insert into role (roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role);

    List<Role> findnotByid(String userid);

    void saveRoletoUser(@Param("userid")String userid,@Param("roleid")String orleid);
}
