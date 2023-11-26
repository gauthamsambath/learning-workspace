package Blind75;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Search in rotated sorted array.
 */
public class SearchInRotatedSortedArray {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println("Position of " + target + " in the array is = " + searchInRotatedSortedArray.search(nums, target));

    }

    /**
     * Search int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public int search(int[] nums, int target) {
        int midPoint = findMinIndex(nums);
        if (target == nums[midPoint])
            return midPoint;
        else if (target < nums[midPoint]) {
            return -1;
        } else {
            if (target < nums[nums.length - 1]) {
                List<Integer> listToSearch = IntStream.of(Arrays.copyOfRange(nums, midPoint, nums.length)).boxed().collect(Collectors.toList());
                int pos = Collections.binarySearch(listToSearch, target);
                return pos < 0 ? -1 : pos+midPoint;
            } else if (target > nums[nums.length - 1]) {
                List<Integer> listToSearch = IntStream.of(Arrays.copyOfRange(nums, 0, midPoint)).boxed().collect(Collectors.toList());
                int pos = Collections.binarySearch(listToSearch, target);
                return pos < 0 ? -1 : pos;
            } else {
                return nums.length - 1;
            }
        }
    }

    /**
     * Find min index int.
     *
     * @param nums the nums
     * @return the int
     */
    public int findMinIndex(int[] nums) {
        if (nums.length == 1 || (nums.length > 2 && nums[0] < nums[nums.length - 1]))
            return 0;
        if (nums.length == 2)
            return nums[0] > nums[1] ? 1 : 0;

        int beg = 0;
        int last = nums.length - 1;
        int mid = (beg + last) / 2;
        while (beg < last) {
            if (nums[mid] < nums[mid - 1])
                return mid;
            if (nums[mid] > nums[nums.length - 1])
                beg = mid + 1;
            else
                last = mid;
            mid = (beg + last) / 2;
        }

        return mid;
    }
}
