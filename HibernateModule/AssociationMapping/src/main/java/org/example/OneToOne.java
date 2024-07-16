package org.example;
import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOne {
    public static void main(String[] args) {
        OneToOne main = new OneToOne();
        main.init();
    }

    void init(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create Person
        Person person = new Person();
        session.save(person);  // This will generate personId for Person

        // Create Address
        Address address = new Address();
        address.setId(person.getId());  // Assign personId as the Address's ID
        address.setPerson(person);  // Set the Person for Address
        session.save(address);

        // Update the Person's address reference
        person.setAddress(address);
        session.update(person);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }

    void get(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Retrieve Address by Person ID
        Address address = session.get(Address.class, 1L);  // Assuming ID 1 for Address
        if (address != null) {
            System.out.println("Address ID: " + address.getId());
            System.out.println("Person ID associated with Address: " + address.getPerson().getId());
        } else {
            System.out.println("Address not found!");
        }

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}