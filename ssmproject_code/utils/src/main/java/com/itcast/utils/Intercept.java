package com.itcast.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Intercept implements HandlerInterceptor {
    /*public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
        if (handler instanceof DefaultServletHttpRequestHandler){return true;}
        HttpSession session = request.getSession();
        User loginuser = (User) session.getAttribute("loginuser");
        if (loginuser!=null){
            return true;
        }else{
            request.getRequestDispatcher("/user/login").forward(request,response);
            return false;
        }
    }*/
}
