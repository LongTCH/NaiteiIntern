package org.example;

import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Map;

public class MapMapping {
    public static void main(String[] args) {
        MapMapping main = new MapMapping();
        main.get();
    }
    void init(){
        // Get a session from the SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create a new library
        Library library = new Library();
        library.setName("City Library");

        // Create books
        Book book1 = new Book();
        book1.setIsbn("1234567890");
        book1.setTitle("Hibernate Basics");
        book1.setLibrary(library);

        Book book2 = new Book();
        book2.setIsbn("0987654321");
        book2.setTitle("Java Persistence");
        book2.setLibrary(library);

        Book book3 = new Book();
        book3.setIsbn("1122334455");
        book3.setTitle("Spring Framework");
        book3.setLibrary(library);

        // Add books to the library
        library.getBooks().put(book1.getIsbn(), book1);
        library.getBooks().put(book2.getIsbn(), book2);
        library.getBooks().put(book3.getIsbn(), book3);

        // Save the library (this will also save the books due to CascadeType.ALL)
        session.save(library);

        // Commit transaction
        session.getTransaction().commit();
        session.close();

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }

    void get(){
        // Get a session from the SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Fetch the library by ID
        int libraryId = 1; // replace with the actual library ID you want to fetch
        Library library = session.get(Library.class, libraryId);

        if (library != null) {
            System.out.println("Library: " + library.getName());
            System.out.println("Books:");
            for (Map.Entry<String, Book> entry : library.getBooks().entrySet()) {
                Book book = entry.getValue();
                System.out.println("ISBN: " + entry.getKey() + ", Title: " + book.getTitle());
            }
        } else {
            System.out.println("Library not found with ID: " + libraryId);
        }

        // Commit transaction
        session.getTransaction().commit();
        session.close();

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}
