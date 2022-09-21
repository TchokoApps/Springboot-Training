package com.tchokouaha.spring.training.demospringboot;

public class Book {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
