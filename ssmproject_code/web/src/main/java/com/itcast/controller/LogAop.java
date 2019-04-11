package com.itcast.controller;
import com.itcast.domain.Syslog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.itcast.controller.UserController.*(..))")
    public void pointcut(){}
    private Method method;
    private Date date;
    private Class aclass;
    @Autowired
    private HttpServletRequest request;
    @Before("pointcut()")
    public void Befor(JoinPoint pj) throws NoSuchMethodException {
        date = new Date();//获取访问时间
        aclass= pj.getTarget().getClass();//类的字节码
        Object[] args = pj.getArgs();//方法的参数集合
        String mehodname = pj.getSignature().getName();//方法名称
        if (args!=null&args.length==0){
          method = aclass.getMethod(mehodname);//无参方法对象
        }else{
           Class[] argClass=new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argClass[i]=args[i].getClass();
            }
            method = aclass.getMethod(mehodname, argClass);//有参构造方法
        }
    }
    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        long l = new Date().getTime()-date.getTime();
        RequestMapping requestMapping=(RequestMapping) aclass.getAnnotation(RequestMapping.class);
        if(aclass!=null&&method!=null&&aclass!=LogAop.class){
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
           String url= requestMapping.value()[0]+annotation.value()[0];
           String remoteAddr = request.getRemoteAddr();
            SecurityContext context = SecurityContextHolder.getContext();
            User user =(User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();
            Syslog syslog = new Syslog();
            String replace = UUID.randomUUID().toString().replace("-", "");
            syslog.setId(replace);
            syslog.setExecutionTime(l);
            syslog.setIp(remoteAddr);
            syslog.setUrl(url);
            syslog.setUsername(username);
            syslog.setVisitTime(date);
            syslog.setMethod("类名"+aclass.getName()+"方法名:"+method.getName());
            System.out.println(syslog);
        }
    }
}
