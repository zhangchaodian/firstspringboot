package com.imooc.framework;

import com.imooc.framework.ioc.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// 注意这个标签已经定义好了@ComponentScan，然后默认只会扫描当前Package以及它的子Package
// 因此如果config和entity包不是在FrameworkApplication当前Package的子包，则需要去指定相关的扫描路径
@SpringBootApplication
public class FrameworkApplication {

    public static void main(String[] args) {
        // SpringApplication.run(FrameworkApplication.class, args);

        // 下面的例子只是作为演示，由于run点击进去返回的ConfigurableApplicationContext
        // ConfigurableApplicationContext又是继承自ApplicationContext
        // 而ApplicationContext实现的多个的继承的最根本又是BeanFactory，所以可以通过getBean获取
        ApplicationContext ctx = SpringApplication.run(FrameworkApplication.class, args);
        Person person = ctx.getBean(Person.class);
        System.out.println("Name is " + person.getName());
        person.call();
    }

}
