package com.testCI.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, Publisher publisher, List<Author> authors) {
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
    }
}