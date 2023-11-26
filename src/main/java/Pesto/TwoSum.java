package Pesto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,3};
        int target = 7;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(arr, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] outputArray = new int[2];
        Map<Integer, Integer> mapOfValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapOfValues.containsKey(target - nums[i])) {
                outputArray[0] = mapOfValues.get(target - nums[i]);
                outputArray[1] = i;
                break;
            }

            if (!mapOfValues.containsKey(nums[i])) {
                mapOfValues.put(nums[i], i);
            }
        }
        return outputArray;
    }
}
