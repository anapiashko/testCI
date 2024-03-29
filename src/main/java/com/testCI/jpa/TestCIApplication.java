package com.testCI.jpa;

import com.testCI.jpa.dao.*;
import com.testCI.jpa.model.Author;
import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import java.util.List;

public class TestCIApplication {

    public static void main(String[] args) {

        AuthorRepo authorRepo = new AuthorRepoImpl();
        BookRepo bookRepo = new BookRepoImpl();
        PublisherRepo publisherRepo = new PublisherRepoImpl();

        Book book1 = new Book("Tyref", null, null);
        Book book2 = new Book("Hory", null, null);

        bookRepo.create(book1);
        bookRepo.create(book2);

        List<Book> books = bookRepo.findAll();

        Author author = new Author("Gabriel", books);

        authorRepo.create(author);

        List<Book> books2 = bookRepo.findAll();

        List<Author> authors = books2.get(0).getAuthors();

        Publisher publisher = new Publisher("publisher2", books2);

        publisherRepo.create(publisher);

        System.out.println(publisherRepo.findAllBooks());

        publisherRepo.create(publisher);
        System.out.println(publisherRepo.findAllBooks());
        publisherRepo.create(publisher);
        System.out.println(publisherRepo.findAllBooks());
    }
}
