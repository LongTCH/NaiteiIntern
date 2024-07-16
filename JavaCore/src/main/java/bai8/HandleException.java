package bai8;

import java.io.IOException;

public class HandleException {
    public void method3() throws IOException {
        throw new IOException();
    }
    public void method1() throws IOException {
        method3();
    }
    public void method2(){
        try {
            method1();
        }catch (Exception e){
            System.out.println("Message " + e.getMessage());
            System.out.println("Message + class'name exception " + e.toString());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        HandleException handleException = new HandleException();
        handleException.method2();
    }
}
