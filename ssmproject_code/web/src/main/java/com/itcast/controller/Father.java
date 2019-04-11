package com.itcast.controller;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Father implements Person2 {
    public Father() {
    }
    @Override
    public void show(Person person) {
        System.out.println("show");
    }
}
