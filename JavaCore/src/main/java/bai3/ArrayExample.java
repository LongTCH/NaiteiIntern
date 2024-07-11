package bai3;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // Tạo mảng
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        // Copy mảng
        int[] copiedArray = Arrays.copyOf(array1, array1.length);
        System.out.println("Mảng sao chép: " + Arrays.toString(copiedArray));
        // So sánh hai mảng
        boolean areArraysEqual = Arrays.equals(array1, array2);
        System.out.println("Hai mảng array1 và array2 có giống nhau không? " + areArraysEqual);
        // Duyệt qua mảng
        System.out.println("Duyệt qua mảng array1:");
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}

