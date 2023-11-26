package Blind75;

/**
 * The type Minimum in rotated sorted array.
 */
public class MinimumInRotatedSortedArray {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] rotatedArray = {5,4};
        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        System.out.println("Minimum value in rotated sorted array = " + minimumInRotatedSortedArray.findMin(rotatedArray));
    }

    /**
     * Find min int.
     *
     * @param nums the nums
     * @return the int
     */
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int beg = 0;
        int last = nums.length - 1;
        int mid = (beg + last) / 2;
        while (beg < last) {
            if (nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[mid] > nums[nums.length - 1])
                beg = mid + 1;
            else
                last = mid;
            mid = (beg + last) / 2;
        }

        return nums[mid];
    }
}
