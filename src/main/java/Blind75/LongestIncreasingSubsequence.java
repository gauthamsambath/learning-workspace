package Blind75;

import java.util.Arrays;

/**
 * The type Longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println("length of the longest increasing subsequence is = " + longestIncreasingSubsequence.lengthOfLIS(nums));

    }

    /**
     * Length of lis int.
     *
     * @param nums the nums
     * @return the int
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int longestIncreasingSubsequenceCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            longestIncreasingSubsequenceCount = Math.max(longestIncreasingSubsequenceCount, dp[i]);
        }
        return longestIncreasingSubsequenceCount;
    }
}
