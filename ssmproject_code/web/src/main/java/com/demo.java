package com;

import com.itcast.controller.Father;
import com.itcast.controller.Person;
import com.itcast.controller.Person2;
import com.itcast.controller.Student;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class demo {
    public static void main(String[] args) {
        Person student = new Student();
        Father father = new Father();
        Person2 person=(Person2) Proxy.newProxyInstance(father.getClass().getClassLoader(), father.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (Object arg : args) {
                    System.out.println(arg.getClass().getName());
                }
                return method.invoke(father,args);
            }
        });
        person.show(student);
    }

}
