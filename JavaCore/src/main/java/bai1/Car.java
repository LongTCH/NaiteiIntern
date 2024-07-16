package bai1;

public class Car {
    // Các trường (fields)
    private int yearOfManufacture;
    private String color;
    // Thuộc tính (Attributes)
    public static final String VEHICLE_TYPE = "Car";
    // Hàm tạo (constructor)
    public Car(int yearOfManufacture, String color) {
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
    }
    // Các phương thức (methods)
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public String getColor() {
        return color;
    }
    // Các khối mã (code block)
    {
        System.out.println("Khối mã được thực thi khi đối tượng được tạo.");
    }
    // Lớp lồng nhau (nested class)
    public static class Engine {
        private String engineType;

        public Engine(String engineType) {
            this.engineType = engineType;
        }

        public String getEngineType() {
            return engineType;
        }
    }
}
