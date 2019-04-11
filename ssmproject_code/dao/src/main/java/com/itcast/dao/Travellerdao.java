package com.itcast.dao;

import com.itcast.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Travellerdao {
    @Select("select * from traveller")
    List<Traveller> findAll();
    @Select("select * from traveller where id=#{id}")
    List<Traveller> findByid(String id);
    List<Traveller> findByOrderid(String orderid);
}
