package com.tchokouaha.spring.training.demospringboot;

import com.tchokouaha.spring.training.demospringboot.vote.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoSpringBootApplication.class, args);

        String[] beanNames = ctx.getBeanNamesForType(Person.class);
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

}
