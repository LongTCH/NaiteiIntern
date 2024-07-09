package bai1;
public class Overloading {
    public int add(int x, int y) {
        return x + y;
    }
    public double add(double x, double y) {
        return x + y;

    }
    public int add(int x, int y, int z) {
        return x + y + z;
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println(o.add(10, 20));
    }

}