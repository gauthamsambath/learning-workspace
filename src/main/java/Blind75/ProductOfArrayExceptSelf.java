package Blind75;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//        You must write an algorithm that runs in O(n) time and without using the division operation.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//        Example 2:
//
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]

import java.util.Arrays;

/**
 * The type Product of array except self.
 */
public class ProductOfArrayExceptSelf {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] listOfNumbers = {-1, 1, 0, -3, 3};
        System.out.println("Array consisting of products except itself = " + Arrays.toString(productExceptSelf(listOfNumbers)));
        System.out.println("Array consisting of products except itself = " + Arrays.toString(productExceptSelfOptimized(listOfNumbers)));
    }

    /**
     * Product except self int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int[] productArray = new int[nums.length];
        leftProducts[0] = nums[0];
        rightProducts[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            leftProducts[i] = leftProducts[i - 1] * nums[i];
            rightProducts[j] = rightProducts[j + 1] * nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                productArray[i] = rightProducts[i + 1];
            else if (i == nums.length - 1)
                productArray[i] = leftProducts[i - 1];
            else
                productArray[i] = leftProducts[i - 1] * rightProducts[i + 1];
        }

        return productArray;
    }

    /**
     * Product except self optimized int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     *
     * this optimized acheives O(1) space complexity
     */
    public static int[] productExceptSelfOptimized(int[] nums) {
        int[] productArray = new int[nums.length];
        productArray[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            productArray[i] = productArray[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArray[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return productArray;
    }
}
