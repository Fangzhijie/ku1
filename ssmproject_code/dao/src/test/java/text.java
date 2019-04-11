
import com.itcast.dao.*;
import com.itcast.domain.*;
import com.itcast.utils.DateforString;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public class text {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springdao.xml");
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Roledao mapper = sqlSession.getMapper(Roledao.class);
        List<Role> roles = mapper.findnotByid("137B1FD29770468B9E46B05EF64A0FCC");
        for (Role role : roles) {
            System.out.println(role);
        }

    }
}
