package com.imooc.framework.ioc.entity;


import org.springframework.stereotype.Component;

@Component
public class Bird implements Pet {

    @Override
    public void move() {
        System.out.println("flying");
    }
}
