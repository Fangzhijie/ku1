package com.itcast.service;

import com.itcast.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrdersService  {
    List<Orders> findAll();

    List<Orders> findAllLimit(int page, int size);

    Orders findById(String id);
}
