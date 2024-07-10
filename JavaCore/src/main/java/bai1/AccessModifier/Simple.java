package bai1.AccessModifier;

public class Simple{
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.data);
//        obj.msg(); //Compile Time Error
    }
}
