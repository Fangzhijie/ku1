package com.itcast.dao;

import com.itcast.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Productdao {
    @Select("select * from product")
    List<Product> findAll();
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)\n" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productprice},#{productDesc},#{productStatus})")
    void save(Product product);
    @Delete("delete product where id=#{id}")
    void dele(String id);
    @Select("select * from product where id=#{id}")
    Product findByid(String id);
}
