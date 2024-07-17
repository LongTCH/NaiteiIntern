package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Person;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateMerge {
    public static void main(String[] args) {
        UpdateMerge updateMerge = new UpdateMerge();
        updateMerge.find();
    }

    void persist() {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Person person = new Person();
        person.setName("John Doe");
        em.persist(person);
        person.setName("Jane Doe"); // Do not need update method
        transaction.commit();
        em.close();
        HibernateUtil.shutdown();
    }

    void find(){
        EntityManager em = HibernateUtil.getEntityManager();
        Person person1 = em.find(Person.class, 1L);
        System.out.println("SQL executed");
        Person person2 = em.getReference(Person.class, 2L);
        System.out.println("SQL not executed");
        person2.getName(); // SQL executed
        em.close();
        HibernateUtil.shutdown();
    }

    void merge() {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        // Assuming a detached entity with an existing ID
        Person person = new Person();
        person.setId(1L); // Existing ID
        person.setName("Updated Name");
        em.merge(person); // Merge the detached entity
        transaction.commit(); // This will flush the session and execute the SQL UPDATE
        em.close();
        HibernateUtil.shutdown();
    }
}
