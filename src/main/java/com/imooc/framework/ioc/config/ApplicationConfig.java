package com.imooc.framework.ioc.config;

import com.imooc.framework.ioc.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作用是告诉如何IOC容器如何去装配下面的entity的person
 */
// 打上了这个标签，就会将Person的实例注入到容器里面
@Configuration
public class ApplicationConfig {
    // Bean标签的作用是将init方法返回的实体类装配到IOC容器中，而name的定义Bean的名称，没有定义，则默认为initPerson
    // 如果每一个需要注入的Bean都这样写，很蛋疼，所以摒弃这种@Configuration和@Bean的结合用法，用更高效的@Component和@Autowired
    // @Bean(name = "person")
    // public Person initPerson() {
    //     Person user = new Person();
    //     user.setId(1L);
    //     user.setName("Jack");
    //     return user;
    // }
}
