package com.testCI.jpa.dao;

import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import java.util.List;

public interface PublisherRepo {

    void create(Publisher publisher);

    List<Publisher> findAll();

    public List<Book> findAllBooks();
}
