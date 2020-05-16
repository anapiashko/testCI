package com.testCI.jpa.dao;

import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import java.util.List;

public interface BookRepo {

    public List<Book> findAll();

    public void create(Book book);

    public Book findByPublisher(Publisher publisher);

}
