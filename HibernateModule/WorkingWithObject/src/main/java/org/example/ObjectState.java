package org.example;
import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ObjectState {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transient state
        Person person = new Person();
        person.setName("John Doe");
        System.out.println("Session contain person: " + session.contains(person));
        // Persistent state
        session.save(person); // Now 'person' is in a persistent state
        System.out.println("Session contain person: " + session.contains(person));
        session.close(); // After closing, 'person' becomes detached
        // Detached state
        person.setName("Jane Doe");
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        System.out.println("Session contain person: " + session.contains(person));
        session.update(person); // Now 'person' is persistent again
        System.out.println("Session contain person: " + session.contains(person));
        session.getTransaction().commit();
        session.close();
        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}