package com.itcast.service.impl;

import com.itcast.dao.Memberdao;
import com.itcast.domain.Member;
import com.itcast.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceimpl implements Memberservice {
    @Autowired
    private Memberdao memberdao;

    public List<Member> findAll() {
        List<Member> all = memberdao.findAll();
        return all;
    }
}
