package com.itcast.controller;
import com.itcast.domain.Member;
import com.itcast.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Member")
public class MemberController {
    @Autowired
    private Memberservice memberservice;
    @RequestMapping("/findAll")
    public void findall(){
        List<Member> all = memberservice.findAll();
        System.out.println(all);
    }
}
