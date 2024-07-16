package bai7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Sender{
    public synchronized void send(String msg){
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Threads interrupted");
        }
        System.out.println("\n" + msg + " Send");
    }
}

class Counter{
    private int count = 0;
    public void inc(String msg){
        synchronized (this){
            System.out.println("Đang in..... " + msg);
        }
        System.out.println("In ra: " + msg);
    }
}
class Counter1{
    private Lock lock = new ReentrantLock();
    public void inc(String msg){
        lock.lock();
        System.out.println("Đang in..... " + msg);
        lock.unlock();
        System.out.println("In ra: " + msg);
    }
}

public class SynThreads {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            counter.inc("Hello ");
        });
        Thread t2 = new Thread(()->{
            counter.inc("Hi ");
        });
        t1.start();
        t2.start();

        Counter1 counter1 = new Counter1();
        Thread t3 = new Thread(()->{
            counter1.inc("Hello ");
        });
        Thread t4 = new Thread(()->{
            counter1.inc("Hi ");
        });
        t3.start();
        t4.start();

//        Sender sender = new Sender();
//        Thread t1 = new Thread(()->
//                sender.send("Hi ")
//        );
//        Thread t2 = new Thread(()->{
//            sender.send("Bye ");
//        });
//
//        t1.start();
//        t2.start();

    }
}
