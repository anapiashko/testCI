//package com.testCI.jpa.dao;
//
//import com.testCI.jpa.model.Author;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class CreateEmployee {
//
//   public static void main( String[ ] args ) {
//
//      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA project" );
//
//      EntityManager entitymanager = emfactory.createEntityManager( );
//      entitymanager.getTransaction( ).begin( );
//
//      Author author = new Author( );
//      author.setId(1201);
//      author.setFirstName( "Gopal" );
//      author.setLastName( "Mark" );
//      author.setBooks();
//
//      entitymanager.persist( author );
//      entitymanager.getTransaction( ).commit( );
//
//      entitymanager.close( );
//      emfactory.close( );
//   }
//}