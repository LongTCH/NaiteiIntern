package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.StaleObjectStateException;

public class OptimisticConcurrencyExample {
    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = null;
        Transaction tx2 = null;
        try {
            // Bắt đầu giao dịch thứ nhất
            tx1 = session1.beginTransaction();
            // Tìm một đối tượng Vehicle
            Vehicle vehicle1 = session1.get(Vehicle.class, 1L);
            System.out.println("Transaction 1 - Read Vehicle: " + vehicle1);
            vehicle1.setColor("Green");
            System.out.println("Transaction 1 - Updated Vehicle to Green but not committed yet");

            // Bắt đầu giao dịch thứ hai
            tx2 = session2.beginTransaction();
            // Tìm cùng một đối tượng Vehicle trong một session khác
            Vehicle vehicle2 = session2.get(Vehicle.class, 1L);
            System.out.println("Transaction 2 - Read Vehicle: " + vehicle2);
            vehicle2.setColor("Blue");
            // Commit của tx2 sẽ gặp lỗi vì tx1 vẫn đang giữ phiên bản cũ
            try {
                tx2.commit();
            } catch (StaleObjectStateException e) {
                System.out.println("Transaction 2 - Optimistic Locking Exception: " + e.getMessage());
            }
            // Hoàn tất tx1
            tx1.commit();
            System.out.println("Transaction 1 - Commit successful");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng session
            session1.close();
            session2.close();
        }
    }
}
