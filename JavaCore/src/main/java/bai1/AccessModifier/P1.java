package bai1.AccessModifier;

public class P1 extends P{
    public static void main(String[] args) {
        P p = new P();
        p.a = 10;
        p.b = 20;
        p.c = 30;
//        p.d    ERROR
    }
}
