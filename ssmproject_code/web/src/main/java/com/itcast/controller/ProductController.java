package com.itcast.controller;
import com.github.pagehelper.PageInfo;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(ServletRequest request){
        List<Product> all = productService.findAll();
        request.setAttribute("productList",all);
        return "product-list";
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/dele")
    public String dele(String [] ids){

        for (String id : ids) {
            productService.dele(id);
        }
        return "redirect:/product/findAll";
    }

    @RequestMapping("/findAllLimit")
    @RolesAllowed("USER")
    public ModelAndView findAllLimit(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "1")int size){
        List<Product> all = productService.findAllLimit(page,size);
        PageInfo<Product> productPageInfo = new PageInfo<>(all);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productPageInfo",productPageInfo);
       modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
