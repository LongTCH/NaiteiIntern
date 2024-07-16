package bai6;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Quên thêm @Override và viết sai tên phương thức
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound(); // Gọi phương thức của lớp Animal
        Dog d = (Dog)new Animal(); // Lỗi biên dịch
        d.makeSound();
    }
}

