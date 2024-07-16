package bai7;

class SharedResource {
    private boolean isAvailable = false;
    public synchronized void produce() {
        try {
            while (isAvailable) {
                wait();
            }
            System.out.println("Produced resource");
            isAvailable = true;
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void consume() {
        try {
            while (!isAvailable) {
                wait();
            }
            System.out.println("Consumed resource");
            isAvailable = false;
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

    public class WaitNotifyExample {
        public static void main(String[] args) {
            SharedResource resource = new SharedResource();

            Thread producer = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.produce();
                }
            });

            Thread consumer = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.consume();
                }
            });
            producer.start();
            consumer.start();
        }
}

