package com.tchokouaha.spring.training.demospringboot;

import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private Book book;

    public Publisher(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
