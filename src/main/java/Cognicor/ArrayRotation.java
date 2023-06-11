package Cognicor;

//Given an Array of size N and a value K, around which you need to right rotate the array. Write an efficient algorithm or pseudocode to implement this.
//
//        Examples :
//
//
//
//        Input: Array[] = {1, 3, 5, 7, 9}, K = 2.
//
//        Output: 7 9 1 3 5
//
//        Explanation:
//
//        After 1st rotation - {9, 1, 3, 5, 7}
//
//        After 2nd rotation - {7, 9, 1, 3, 5}
//
//
//        Input: Array[] = {1, 2, 3, 4, 5}, K = 4.
//
//        Output: 2 3 4 5 1

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int k = 7;
        k = k%arr.length;
        int [] rotatedArray = new int[arr.length];

        int j =0;
        for (int i = arr.length - k; i < arr.length; i++) {
            rotatedArray[j++] = arr[i];
        }

        int m =0;
        for (int i = j ; i < arr.length;i++){
            rotatedArray[i] = arr[m++];
        }

        System.out.println("Actual array = "+Arrays.toString(arr));
        System.out.println("rotated array = "+Arrays.toString(rotatedArray));
    }
}
