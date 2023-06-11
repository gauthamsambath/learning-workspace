package Blind75;

//Contains Duplicate
//        Easy
//        9.5K
//        1.2K
//        Companies
//        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: true
//        Example 2:
//
//        Input: nums = [1,2,3,4]
//        Output: false
//        Example 3:
//
//        Input: nums = [1,1,1,3,3,4,3,2,4,2]
//        Output: true

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] listOfNumbers = {1,2,3,4};
        System.out.println("This list " + (containsDuplicate(listOfNumbers)?"does ":"does not ")+"contain duplicates" );

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> setOfIntegers = new HashSet<>();
        for (int a : nums) {
            if (!setOfIntegers.add(a))
                return true;
        }
        return false;
    }
}


