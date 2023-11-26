package Blind75;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        System.out.println("Maximum Product possible with any sub array is = "+maximumProductSubArray.maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        int localMax= nums[0];
        int localMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = localMax;
            int tempMin = localMin;
            localMax = Math.max(nums[i],Math.max(tempMax*nums[i],tempMin*nums[i]));
            localMin = Math.min(nums[i],Math.min(tempMax*nums[i],tempMin*nums[i]));
            maxProduct = Math.max(maxProduct,localMax);
        }

        return maxProduct;
    }
}
