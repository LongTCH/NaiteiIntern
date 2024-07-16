package org.example;

import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

public class ManyToMany {
    public static void main(String[] args) {
        ManyToMany main = new ManyToMany();
        main.get();
    }

    void init(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create Authors
        Author author1 = new Author();
        author1.setName("John Doe");
        session.save(author1);

        Author author2 = new Author();
        author2.setName("Jane Smith");
        session.save(author2);

        // Create Books and associate with Authors
        Book book1 = new Book();
        book1.setTitle("Hibernate Basics");
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);
        session.save(book1);

        Book book2 = new Book();
        book2.setTitle("Java Persistence with JPA");
        book2.getAuthors().add(author1);
        session.save(book2);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }

    void get(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Retrieve Book by ID
        Book book = session.get(Book.class, 1L);  // Assuming ID 1 for Book
        if (book != null) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Authors:");
            for (Author author : book.getAuthors()) {
                System.out.println("- Author ID: " + author.getId() + ", Name: " + author.getName());
            }
        } else {
            System.out.println("Book not found!");
        }

        // Retrieve Book by ID
        Author author = session.get(Author.class, 1L);  // Assuming ID 1 for Book
        if (author != null) {
            System.out.println("Author ID: " + author.getId());
            System.out.println("Author Name: " + author.getName());
            System.out.println("Books:");
            for (Book b : author.getBooks()) {
                System.out.println("- Book ID: " + b.getId() + ", Title: " + b.getTitle());
            }
        } else {
            System.out.println("Author not found!");
        }

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
