package Blind75Practise;

/**
 * The type Find minimum in rotated sorted array.
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] rotatedSortedArrayToFindMin = {2,3,1};
        FindMinimumInRotatedSortedArray findMin = new FindMinimumInRotatedSortedArray();
        System.out.println("Minimunm element is = " + findMin.findMin2(rotatedSortedArrayToFindMin));
    }

    /**
     * Find min int.
     *
     * @param nums the nums
     * @return the int
     */
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int mid = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            if (nums[first] < nums[last]) {
                return nums[first];
            } else if (nums[mid] < nums[nums.length - 1]) {
                if ((mid == nums.length - 1 && nums[mid] < nums[mid - 1]) || (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])) {
                    return nums[mid];
                } else {
                    last = mid - 1;
                }
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return nums[mid];
    }

    public int findMin2(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];
        int beg = 0;
        int last = nums.length;
        int mid = 0;
        while (beg < last) {
            mid = (beg + last) / 2;
            if (nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[mid] > nums[nums.length - 1])
                beg = mid + 1;
            else
                last = mid;
        }
        return nums[mid];
    }
}
