package com.itcast.dao;

import com.itcast.domain.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Ordersdao {
  /*  @Select("select * from orders")*/
    List<Orders> findAll();

    Orders findByid(String id);
}
