package com.itcast.service;

import com.itcast.domain.Product;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    List<UserInfo> findAll();

    List<UserInfo> findAllLimit(Integer page, Integer size);

    void save(UserInfo userInfo);

    UserInfo findById(String id);



}
