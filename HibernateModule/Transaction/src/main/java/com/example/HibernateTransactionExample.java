package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Connection;
import java.sql.Savepoint;
public class HibernateTransactionExample {
    public static void main(String[] args) {
        // Lấy session từ Hibernate SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Bắt đầu giao dịch
        Transaction transaction = null;
        Savepoint savepoint1 = null;
        try {
            transaction = session.beginTransaction();
            VehicleOwner owner = new VehicleOwner();
            owner.setName("John Doe");
            session.save(owner);
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber("ABC123");
            vehicle.setManufacturer("Toyota");
            vehicle.setYearOfManufacture(2020);
            vehicle.setColor("Red");
            vehicle.setOwner(owner);
            session.save(vehicle);
            // Lấy Connection từ session
            Connection connection = session.doReturningWork(connection1 -> connection1);
            // Thiết lập savepoint
            savepoint1 = connection.setSavepoint("Savepoint1");
            // Thay đổi một số thông tin và lưu lại
            vehicle.setColor("Blue");
            session.update(vehicle);
            connection.rollback(savepoint1);
            // Commit giao dịch
//            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus() == TransactionStatus.ACTIVE) {
                try {
                    if (savepoint1 != null) {
                        Connection connection = session.doReturningWork(connection1 -> connection1);
                        connection.rollback(savepoint1);
                    }
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
