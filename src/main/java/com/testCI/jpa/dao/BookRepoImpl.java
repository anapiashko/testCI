package com.testCI.jpa.dao;

import com.testCI.jpa.model.Author;
import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookRepoImpl implements BookRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void create(Book book) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(book);
        entitymanager.getTransaction().commit();
    }

    public Book findByPublisher(Publisher publisher) {
        Query query = entitymanager.createQuery("select b from Book b where b.publisher =: publisher")
                .setParameter("publisher", publisher);

        Book book = (Book) query.getResultList();
        return book;
    }

    public List<Book> findAll() {
        Query query = entitymanager.createQuery("Select b from Book b");
        List<Book> authors = query.getResultList();
        return authors;
    }
}
