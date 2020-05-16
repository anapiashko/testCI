package com.testCI.jpa.dao;


import com.testCI.jpa.model.Author;
import com.testCI.jpa.model.Book;

import java.util.List;

public interface AuthorRepo {

    void create(Author author);

    List<Author> findAll();
}
