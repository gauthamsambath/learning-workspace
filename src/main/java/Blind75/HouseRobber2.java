package Blind75;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] houseCash = {0};
        HouseRobber2 houseRobber = new HouseRobber2();
        System.out.println("Maximum cash obtained while robbing houses = " + houseRobber.rob(houseCash));
    }

    private int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robWithoutCircularArrangement(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robWithoutCircularArrangement(Arrays.copyOfRange(nums, 1, nums.length)));
    }


    public int robWithoutCircularArrangement(int[] nums) {
        int totalLength = nums.length;
        int[] dp = new int[nums.length];
        dp[totalLength - 1] = nums[totalLength - 1];
        dp[totalLength - 2] = Math.max(dp[totalLength - 1], nums[totalLength - 2]);
        for (int i = totalLength - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
