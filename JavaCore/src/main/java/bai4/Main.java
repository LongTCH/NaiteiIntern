package bai4;

class Shape {
    String color;
    public Shape(String color) {
        this.color = color;
    }
    public void draw() {
        System.out.println("Drawing a shape");
    }
    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    public Circle(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle of color: " + getColor());
    }
}

class Square extends Shape {
    public Square(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square of color: " + getColor());
    }
}

class Triangle extends Shape {
    public Triangle(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle of color: " + getColor());
    }
}

class Rectangle extends Shape {
    public Rectangle(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of color: " + getColor());
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("orange");
        Shape square = new Square("green");
        Shape triangle = new Triangle("yellow");
        Shape rectangle = new Rectangle("purple");
        circle.draw();
        square.draw();
        triangle.draw();
        rectangle.draw();
    }
}
