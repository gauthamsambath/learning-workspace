package Practising;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int mid = arr.length / 2;
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[arr.length - mid];

        System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(arr, mid, secondHalf, 0, secondHalf.length);

        System.out.println("First half = " + Arrays.toString(firstHalf));
        System.out.println("Second half = " + Arrays.toString(secondHalf));
    }
}
