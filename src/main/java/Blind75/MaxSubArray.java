package Blind75;

/**
 * The type Max sub array.
 */
public class MaxSubArray {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayToFindMaximumSubArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println("Sum of the maximum sub array is = " + maxSubArray.maxSubArray(arrayToFindMaximumSubArray));
        System.out.println("Sum of the maximum sub array in the optimized method is = " + maxSubArray.maxSubArrayOptimized(arrayToFindMaximumSubArray));

    }

    /**
     * Max sub array int.
     *
     * @param nums the nums
     * @return the int
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxSum = 0;
        int sum = 0;
        int greatestNegativeNumber = Integer.MIN_VALUE;
        int negativeCount = 0;
        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
                greatestNegativeNumber = Math.max(greatestNegativeNumber, num);
            }
            sum += num;
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }

        if (negativeCount == nums.length)
            return greatestNegativeNumber;

        return maxSum;
    }

    /**
     * Max sub array optimized int.
     *
     * @param nums the nums
     * @return the int
     */
    public int maxSubArrayOptimized(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


}
