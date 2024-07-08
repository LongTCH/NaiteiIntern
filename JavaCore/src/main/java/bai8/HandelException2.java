package bai8;

import java.io.IOException;

public class HandelException2 {

    // UnChecked.
//    public void division(int num1, int num2){
//        System.out.println(num1/num2);
//    }
//
//
//    public static void main(String[] args) {
//        try {
//            HandelException2 handelException2 = new HandelException2();
//            handelException2.division(7,0);
//        }catch (ArithmeticException e){
//            System.out.println("Exception " + e);
//        }catch (Exception e1){
//            e1.printStackTrace();
//        }finally {
//            System.out.println("Exception");
//        }
//    }

    // throw và throws?
    static int sum(int num1, int num2) throws IOException {
        if (num1 == 0)
            throw new ArithmeticException("First parameter is not valid");
        else
            System.out.println("Both parameters are correct!!");
            //throw new IOException("Exception IO");
        return num1 + num2;
    }
    public static void main(String args[]) {
        try {
            int res = sum(0, 12);
            System.out.println(res);
        } catch (ArithmeticException | IOException e) {
            System.out.println("Catch exception: " + e.getMessage());
        }
    }
}
