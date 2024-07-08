package bai7;

import jdk.jfr.Enabled;

public class Initthreads implements Runnable {
    public void run() {
        System.out.println("Thread is running");
        System.out.println("Thread priority as: " + Thread.currentThread().getPriority());
    }
    public static void main(String[] args) {
        Initthreads r1 = new Initthreads();
        Thread t1 = new Thread(r1);
        Initthreads r2 = new Initthreads();
        Thread t2 = new Thread(r2);

        Thread t3 = new Thread("Đây là t3");

        Initthreads r4 = new Initthreads();
        Thread t4 = new Thread(r4, "Đây là t4");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());
        System.out.println(t4.getName());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("END");
    }
}
