package com.testCI.jpa;

import com.testCI.jpa.dao.*;
import com.testCI.jpa.model.Author;
import com.testCI.jpa.model.Book;
import com.testCI.jpa.model.Publisher;

import java.util.*;
import java.util.stream.Collectors;

public class TestCIApplication {

    public static void main(String[] args) {

        Map<String, Integer> headersMap = new HashMap<>();
        headersMap.put("ArticleNumber", 0);
        headersMap.put("AudienceCategories", 1);
        headersMap.put("CustomerCategories", 2);
        headersMap.put("Details__c", 3);
        headersMap.put("Id", 4);
        headersMap.put("ProductCategories", 5);
        headersMap.put("Resolution", 6);
        headersMap.put("Summary", 7);
        headersMap.put("Title", 8);
        headersMap.put("UrlName", 9);
        headersMap.put("VisiblePublicKB", 10);
        headersMap.put("LastModifiedDate", 11);
        headersMap.put("PublishStatus", 12);

        List<String> headers = new ArrayList<>(headersMap.keySet());
        List<String> mandatoryFields = Arrays.asList("Id", "Title", "Details__c");
        List<String> optionalFields = headers.stream().filter(header -> !mandatoryFields.contains(header)).collect(Collectors.toList());
        System.out.println(optionalFields);
        System.out.println(optionalFields);

        String metadataColumns = "CustomerCategories ,ProductCategories, Resolution,Summary,UrlName,VisiblePublicKB,LastModifiedDate,PublishStatus";
        String[] metadata = metadataColumns.split(" *, *");
        System.out.println(Arrays.toString(metadata));

//        AuthorRepo authorRepo = new AuthorRepoImpl();
//        BookRepo bookRepo = new BookRepoImpl();
//        PublisherRepo publisherRepo = new PublisherRepoImpl();
//
//        Book book1 = new Book("Tyref", null, null);
//        Book book2 = new Book("Hory", null, null);
//
//        bookRepo.create(book1);
//        bookRepo.create(book2);
//
//        List<Book> books = bookRepo.findAll();
//
//        Author author = new Author("Gabriel", "Scany",books);
//
//       authorRepo.create(author);
//     //  System.out.println(authorRepo.findAll());
//
//       Publisher publisher = new Publisher("publisher", books);
//
//       publisherRepo.create(publisher);
//        System.out.println(publisherRepo.findAllBooks());
    }
}
