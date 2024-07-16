package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId")
    private int ticketId;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customer;

    // Getters and Setters

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
