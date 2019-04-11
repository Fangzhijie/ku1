package com.itcast.dao;

import com.itcast.domain.Member;
import org.apache.ibatis.annotations.Select;
import java.util.List;
public interface Memberdao {
    @Select("select * from member")
    List<Member> findAll();
    @Select("select * from Member where id=#{id}")
    Member findByid(String id);
}
