package bai3;

public class demo {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = " java";
        String str3 = str1 + str2;
        System.out.println(str3);
        //length
        System.out.println(str1.length());
        //substring
        System.out.println(str1.substring(2));
        //contains
        boolean result1 = str1.contains("llo");
        System.out.println( result1);
        //replace
        String replacedStr1 = str1.replace('l', 'o');
        System.out.println(replacedStr1);

    }
}
