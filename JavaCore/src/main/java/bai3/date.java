package bai3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class date {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Hôm nay: " + today);
        // Tạo ngày cụ thể
        LocalDate specificDate = LocalDate.of(2024, 7, 11);
        System.out.println("Ngày cụ thể: " + specificDate);
        // Thêm 10 ngày vào ngày hiện tại
        LocalDate futureDate = today.plusDays(10);
        System.out.println("Ngày sau 10 ngày: " + futureDate);
        // Lấy ngày và giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Ngày và giờ hiện tại: " + now);
        // Tạo ngày và giờ cụ thể
        LocalDateTime specificDateTime = LocalDateTime.of(2024, 7, 11, 15, 45);
        System.out.println("Ngày và giờ cụ thể: " + specificDateTime);

    }
}
