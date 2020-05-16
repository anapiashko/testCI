package com.testCI.jpa.dao;

import com.testCI.jpa.model.Author;
import com.testCI.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AuthorRepoImpl implements AuthorRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void create(Author author) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(author);
        entitymanager.getTransaction().commit();
    }

    public List<Author> findAll() {
        Query query = entitymanager.createQuery("Select a from Author a");
        List<Author> authors = query.getResultList();
        return authors;
    }
}
