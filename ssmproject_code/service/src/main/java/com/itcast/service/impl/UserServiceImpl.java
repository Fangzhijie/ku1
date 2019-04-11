package com.itcast.service.impl;
import com.github.pagehelper.PageHelper;
import com.itcast.dao.Userdao;
import com.itcast.domain.Orders;
import com.itcast.domain.Product;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private Userdao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findByUsername(username);

        // User user = new User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0 ? false:true,true,true,true,getSimpleGrantedAuthority(userInfo.getRoles()));

        return user;
    }
    public List<SimpleGrantedAuthority> getSimpleGrantedAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            String roleName = role.getRoleName();
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roleName));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> all = userDao.findAll();
        return all;
    }

    @Override
    public List<UserInfo> findAllLimit(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<UserInfo> all = userDao.findAll();
        return all;
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo byid = userDao.findByid(id);
        return byid;
    }


}

