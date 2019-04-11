package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.Memberdao;
import com.itcast.dao.Ordersdao;
import com.itcast.domain.Member;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceimpl implements OrdersService{
    @Autowired
    private Ordersdao ordersdao;
    public List<Orders> findAll() {
        List<Orders> all = ordersdao.findAll();
        return all;
    }
    public List<Orders> findAllLimit(int page,int size) {
        PageHelper.startPage(page,size);
        List<Orders> all = ordersdao.findAll();
        return all;
    }

    public Orders findById(String id) {
        Orders order = ordersdao.findByid(id);
        int size = order.getTravellers().size();
        order.setPeopleCount(size);
        return order;
    }
}
