package org.example.entities;

import jakarta.persistence.*;
import org.example.comparator.TicketComparator;
import org.hibernate.annotations.SortComparator;
import org.hibernate.type.SortedSetType;

import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUST_ID")
    @SortComparator(TicketComparator.class)
    private SortedSet<Ticket> tickets = new TreeSet<>();

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(SortedSet<Ticket> tickets) {
        this.tickets = tickets;
    }
}