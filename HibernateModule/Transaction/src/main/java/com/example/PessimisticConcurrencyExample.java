package com.example;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PessimisticConcurrencyExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = null;
        Transaction tx2 = null;
        try {
            tx1 = session.beginTransaction();
            // Tìm một đối tượng Vehicle với khóa pessimistic lock
            Vehicle vehicle1 = session.get(Vehicle.class, 1L, LockMode.PESSIMISTIC_WRITE);
            System.out.println("Transaction 1 - Read Vehicle: " + vehicle1);
            vehicle1.setColor("Green");
            tx1.commit();
            System.out.println("Transaction 1 - Commit successful");
            // Bắt đầu giao dịch thứ hai
            tx2 = session.beginTransaction();
            Vehicle vehicle2 = session.get(Vehicle.class, 1L, LockMode.PESSIMISTIC_WRITE);
            System.out.println("Transaction 2 - Read Vehicle: " + vehicle2);
            vehicle2.setColor("Blue");
            // Commit để thấy hiện tượng cạnh tranh
            tx2.commit();
            System.out.println("Transaction 2 - Commit successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
