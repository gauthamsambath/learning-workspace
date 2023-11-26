package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Subsets.
 */
public class Subsets {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayToFindAllSubsets = {1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println("List of all the subsets using recursive method is = " + subsets.subsets(arrayToFindAllSubsets));
        System.out.println("List of all the subsets using bit manipulation = " + subsets.subsets2(arrayToFindAllSubsets));
    }

    /**
     * Subsets list.
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> listOfAllSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubsets(listOfAllSubsets, 0, nums.length, nums, subset);
        return listOfAllSubsets;
    }

    /**
     * Find subsets.
     *
     * @param listOfAllSubsets the list of all subsets
     * @param indexRightNow    the index right now
     * @param length           the length
     * @param nums             the nums
     * @param subset           the subset
     */
    private void findSubsets(List<List<Integer>> listOfAllSubsets, int indexRightNow, int length, int[] nums, List<Integer> subset) {
        if (indexRightNow == length) {
            listOfAllSubsets.add(subset);
            return;
        }

        List<Integer> subset2 = new ArrayList<>(subset);

        subset.add(nums[indexRightNow++]);

        findSubsets(listOfAllSubsets, indexRightNow, length, nums, subset);
        findSubsets(listOfAllSubsets, indexRightNow, length, nums, subset2);
    }

    /**
     * Subsets 2 list.
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> listOfAllSubsets = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            listOfAllSubsets.add(subset);
        }

        return listOfAllSubsets;
    }
}
