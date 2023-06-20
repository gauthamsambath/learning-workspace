package DSAProblems;

import java.util.ArrayList;

public class MAxSumSubArray {

    public static void main(String[] args) {
        int[] arr1 = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        int[] arr2 = {1, 2, 3, 7, 5};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {142, 112, 54, 69, 148, 45, 63, 158, 38, 60, 124, 142, 130, 179, 117, 36, 191, 43, 89, 107, 41, 143, 65, 49, 47, 6, 91, 130, 171, 151, 7, 102, 194, 149, 30, 24, 85, 155, 157, 41, 167, 177, 132, 109, 145, 40, 27, 124, 138, 139, 119, 83, 130, 142, 34, 116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146, 125, 73, 71, 30, 178, 174, 98, 113};
        int[] arr5 = {2, 3, 4, 5};
//        System.out.println("first and last index are" + subarraySum(arr1, arr1.length, 468));
//        System.out.println("first and last index are" + subarraySum(arr2, 5, 12));
//        System.out.println("first and last index are" + subarraySum(arr3, arr3.length, 15));
//        System.out.println("first and last index are" + subarraySum(arr4, arr4.length, 665));
        System.out.println("first and last index are" + subarraySum(arr5, arr5.length, 1));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int l = 0;
        int r = 0;
        int sum = arr[l];
        boolean found = false;
        ArrayList<Integer> indexes = new ArrayList<>();
        if (s == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    indexes.add(i + 1);
                    indexes.add(i + 1);
                    return indexes;
                } else {
                    indexes.add(-1);
                    return indexes;
                }
            }
        }
        while (r <= n - 1) {
            if (sum < s && r < n - 1) {
                r++;
                sum += arr[r];
            } else if (sum > s) {
                sum -= arr[l];
                l++;
            } else if (sum == s) {
                found = true;
                break;
            } else {
                found = false;
                break;
            }
        }
        if (!found)
            indexes.add(-1);
        else {
            indexes.add(l + 1);
            indexes.add(r + 1);
        }

        return indexes;
    }
}
