package com.imooc.framework.ioc.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dog implements Pet {
    @Override
    public void move() {
        System.out.println("running");
    }
}
