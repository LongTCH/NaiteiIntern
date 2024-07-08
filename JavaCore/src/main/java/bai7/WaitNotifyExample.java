package bai7;

class SharedResource {
    private boolean isAvailable = false;

    public synchronized void produce() {
        try {
            // Kiểm tra nếu tài nguyên đang có sẵn thì đợi
            while (isAvailable) {
                wait();
            }
            // Tạo tài nguyên (ví dụ: thêm dữ liệu)
            System.out.println("Produced resource");
            isAvailable = true;
            // Đánh thức thread đang đợi
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void consume() {
        try {
            // Kiểm tra nếu tài nguyên không có sẵn thì đợi
            while (!isAvailable) {
                wait();
            }
            // Tiêu thụ tài nguyên (ví dụ: sử dụng dữ liệu)
            System.out.println("Consumed resource");
            isAvailable = false;
            // Đánh thức thread đang đợi
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

    public class WaitNotifyExample {
        public static void main(String[] args) {
            SharedResource resource = new SharedResource();

            // Thread sản xuất (Producer thread)
            Thread producer = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.produce();
                }
            });

            // Thread tiêu thụ (Consumer thread)
            Thread consumer = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.consume();
                }
            });

            producer.start();
            consumer.start();
        }
}

