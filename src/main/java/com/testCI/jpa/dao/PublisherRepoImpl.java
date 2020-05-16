package com.testCI.jpa.dao;

import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void create(Publisher publisher) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(publisher);
        entitymanager.getTransaction().commit();
    }

    public List<Publisher> findAll() {
        Query query = entitymanager.createQuery("Select p from Publisher p");
        List<Publisher> publishers = query.getResultList();
        return publishers;
    }

    public List<Book> findAllBooks(){
        Query query = entitymanager.createQuery("Select p.books from Publisher p");
        List<Book> books = query.getResultList();
        return books;
    }
}
