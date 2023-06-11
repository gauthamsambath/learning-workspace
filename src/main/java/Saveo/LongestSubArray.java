package Saveo;
//Given an array of integers, find the length of the longest sub-array with a sum that equals 0.
//        Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

//15,13,15,7,8,15,25,48
//
//        Output: 5
//
//5,4,2,-5,-6,7
//
//5,9,11,6,0,7
//
//
//15

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LongestSubArray {
    public static void main(String[] args) {
//        int []arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int []arr = {5,4,2,-5,-5,7};
        int sum = 0;
        int Max = 0;
        Map<Integer, Integer> integerListMap = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++) {
            sum+=arr[i];
            if (sum == 0) {
                Max = i+1;
            }
            if (integerListMap.containsKey(sum)) {
                Max = Math.max(Max,i-integerListMap.get(sum));
            } else {
                integerListMap.put(sum,i);
            }
        }

        System.out.println("max length of sub array with sum 0 ="+Max);

    }
}
