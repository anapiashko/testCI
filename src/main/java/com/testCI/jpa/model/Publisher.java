package com.testCI.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
}