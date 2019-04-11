package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.dao.Ordersdao;
import com.itcast.domain.Orders;
import com.itcast.domain.Product;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class Orderscontroller {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findall")
    public String findAll(HttpServletRequest request){
        List<Orders> all = ordersService.findAll();
        request.setAttribute("ordersList",all);
        return "orders-list";
    }
    @RequestMapping("/findAllLimit")
    public String findAllLimit(@RequestParam(value = "page",required = true,defaultValue = "1")Integer page, @RequestParam(value = "size",required = true,defaultValue = "1")Integer size, HttpServletRequest request){
        List<Orders> all = ordersService.findAllLimit(page,size);
        PageInfo<Orders> ordersPageInfo = new PageInfo<Orders>(all);
        request.setAttribute("ordersPageInfo",ordersPageInfo);
        return "orders-list";
    }
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id")String id,HttpServletRequest request){
        Orders order=ordersService.findById(id);
        request.setAttribute("orders",order);
        return "orders-show";
    }

}
