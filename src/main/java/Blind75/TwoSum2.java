package Blind75;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] arrayOfNumbers = {-1,0};
        int[] arrayOfNumbers2 = {1, 10, 100, 115,220};
        int target = -1;
        int target2 = 231;
        TwoSum2 twoSum2 = new TwoSum2();
        System.out.println("The indices in the array which adds upto the target " + target + " are " + Arrays.toString(twoSum2.twoSum(arrayOfNumbers, target)));
        System.out.println("The indices in the array which adds upto the target " + target2 + " are " + Arrays.toString(twoSum2.twoSum(arrayOfNumbers2, target2)));

    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = 1;
        boolean indexesFound = false;
        while (r < numbers.length) {
            if (numbers[l] + numbers[r] == target) {
                indexesFound = true;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
                r++;
            } else {
                while (numbers[l] + numbers[r] > target) {
                    l--;
                }
            }

        }
        if (indexesFound) {
            return new int[]{l+1, r+1};
        } else {
            return new int[2];
        }
    }
}
