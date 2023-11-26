package Blind75;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println("missing number in the array is equal to = " + missingNumber.missingNumber(nums));

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;
        int sum = Arrays.stream(nums).sum();
        return totalSum - sum;
    }
}
