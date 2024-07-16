package bai2;

public class Example {
    public static void main(String[] args) {
        //if else
//        int time = 2;
//        if (time < 10) {
//            System.out.println("Good morning.");
//        } else if (time < 18) {
//            System.out.println("Good day.");
//        } else {
//            System.out.println("Good evening.");
//        }

        // switch case
//        int day = 2;
//        switch (day) {
//            case 1:
//                System.out.println( "Monday"); ;
//                break;
//            case 2:
//                System.out.println("Tuesday") ;
//                break;
//            case 3:
//                System.out.println( "Wednesday") ;
//                break;
//            case 4:
//                System.out.println( "Thursday") ;
//                break;
//            default:
//                System.out.println( "Invalid entry") ;

        //loop
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        }

        //while
//        int num = 5;
//        while (num <=5) {
//            System.out.println("Number: " + num);
//            num++;
//        }

        //do while
//        int num= 1;
//        do{
//            System.out.println( "Number: " +num);
//            num++;
//        } while(num <= 5);


        //Nested Loops
//        for (int i = 1; i <= 2; i++) {
//            System.out.println("Outer: " + i);
//            // Inner loop
//            for (int j = 1; j <= 3; j++) {
//                System.out.println(" Inner: " + j);
//            }
//        }

        //break
//        for (int i = 0; i < 10; i++) {
//            if (i == 4) {
//                break;
//            }
//            System.out.println(i);
//        }
        //continue
//        for (int i = 0; i < 10; i++) {
//            if (i == 4) {
//                continue;
//            }
//            System.out.println(i);
//        }
        //break with label
        outer:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (i == 1 && j == 2) {
                    break outer;
                }
            }
        }

    }
}