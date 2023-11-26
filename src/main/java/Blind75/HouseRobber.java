package Blind75;

public class HouseRobber {

    public static void main(String[] args) {
        int[] houseCash = {2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println("Maximum cash obtained while robbing houses = " + houseRobber.rob(houseCash));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1)
            return nums[0];
        else {
            dp[nums.length - 1] = nums[nums.length - 1];
            dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            if (nums.length > 2) {
                for (int i = nums.length - 3; i >= 0; i--) {
                    dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
                }
            }
            return dp[0];
        }
    }
}
