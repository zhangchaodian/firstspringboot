package com.imooc.framework.ioc.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    @Value("1")
    private Long id;
    @Value("Jack")
    private String name;

    @Autowired
    // 注意pet有提示报错，这样子spring无法找到到底是dog还是bird
    // 会根据属性的类型Pet找到对应的Bean进行注入，注入的最基本的一条就是根据类型
    // 回顾Spring IOC 容器的顶级接口BeanFactory，是通过getBean方法获取对应的Bean
    // 而getBean可以通过对应的类型和名称获取Bean，所以这里会去找Dog和Bird，所以报错，需要在需要优先注入的Bean加入@Primary
    private Pet pet;

    public void call() {
        pet.move();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
