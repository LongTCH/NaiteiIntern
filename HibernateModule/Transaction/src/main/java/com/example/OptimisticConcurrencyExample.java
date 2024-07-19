package com.example;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class OptimisticConcurrencyExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new UpdateVehicleTask(1L, "Green"));
        Thread thread2 = new Thread(new UpdateVehicleTask(1L, "Blue"));
        thread1.start();
        thread2.start();
    }
}
class UpdateVehicleTask implements Runnable {
    private Long vehicleId; private String newColor;
    public UpdateVehicleTask(Long vehicleId, String newColor) {
        this.vehicleId = vehicleId;
        this.newColor = newColor;
    }
    @Override
    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, vehicleId);
            System.out.println(Thread.currentThread().getName() + " - Read Vehicle: " + vehicle);
            vehicle.setColor(newColor);
            tx.commit();
            System.out.println(Thread.currentThread().getName() + " - Commit successful");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
