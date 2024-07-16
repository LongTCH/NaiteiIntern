package org.example.comparator;

import org.example.entities.Ticket;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        return -Integer.compare(t1.getPrice(), t2.getPrice());
    }
}
