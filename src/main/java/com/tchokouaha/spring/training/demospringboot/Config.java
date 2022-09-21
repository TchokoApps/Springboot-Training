package com.tchokouaha.spring.training.demospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean
    @Primary
    public Book book1() {
        return new Book("Java 8");
    }

    @Bean
    public Book book2() {
        return new Book("Java 17");
    }
}
