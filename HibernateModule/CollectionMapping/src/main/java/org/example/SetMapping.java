package org.example;

import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SetMapping {
    public static void main(String[] args) {
        SetMapping main = new SetMapping();
        main.get();
    }

    void init(){
        // Get a session from the SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create a new customer
        Customer customer = new Customer();
        customer.setName("John Doe");

        // Create tickets
        Ticket ticket1 = new Ticket();
        ticket1.setPrice(100);
        ticket1.setCustomer(customer);

        Ticket ticket2 = new Ticket();
        ticket2.setPrice(200);
        ticket2.setCustomer(customer);

        Ticket ticket3 = new Ticket();
        ticket3.setPrice(150);
        ticket3.setCustomer(customer);

        // Add tickets to the customer
        customer.getTickets().add(ticket1);
        customer.getTickets().add(ticket2);
        customer.getTickets().add(ticket3);

        // Save the customer (this will also save the tickets due to CascadeType.ALL)
        session.save(customer);

        // Commit transaction
        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }

    void get(){
        // Get a session from the SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Fetch the customer by ID
        int customerId = 1; // replace with the actual customer ID you want to fetch
        Customer customer = session.get(Customer.class, customerId);

        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Tickets:");
            for (Ticket ticket : customer.getTickets()) {
                System.out.println("Ticket ID: " + ticket.getTicketId() + ", Price: " + ticket.getPrice());
            }
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }

        // Commit transaction
        session.getTransaction().commit();
        session.close();

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}
