package Blind75;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Three some.
 */
public class ThreeSome {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSome threeSome = new ThreeSome();
//        System.out.println("The list of triplets forming sum 0 are = " + threeSome.threeSum(nums));
        System.out.println("The list of triplets forming sum 0 are = " + threeSome.threeSumOptimized(nums));
    }

    /**
     * Remove duplicates list.
     *
     * @param listOfTriplets the list of triplets
     * @return the list
     */
    private static List<List<Integer>> removeDuplicates(List<List<Integer>> listOfTriplets) {
        Set<List<Integer>> duplicateRemovingSet = new HashSet<>();
        List<List<Integer>> withoutDuplicateList = new ArrayList<>();
        for (int i = 0; i < listOfTriplets.size(); i++) {
            List<Integer> listOfIntegers = new ArrayList<>(listOfTriplets.get(i));
            Collections.sort(listOfIntegers);
            if (duplicateRemovingSet.add(listOfIntegers)) {
                withoutDuplicateList.add(listOfTriplets.get(i));
            }
        }
        return withoutDuplicateList;
    }

    /**
     * Gets triplet.
     *
     * @param a       the a
     * @param numList the num list
     * @return the triplet
     */
    private static List<List<Integer>> getTriplet(int a, List<Integer> numList) {
        List<List<Integer>> tripletMap = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numList.size(); i++) {
            int number = numList.get(i);
            int numberTocheck = (-1 * a) - number;
            if (numMap.containsKey(numberTocheck) && numMap.get(numberTocheck) != i) {
                tripletMap.add(Arrays.asList(a, number, numberTocheck));
            }
            numMap.put(number, i);
        }
        return tripletMap;
    }

    /**
     * Three sum list.
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfTriplets = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int lengthOfList = numList.size();
        for (int i = 0; i < lengthOfList; i++) {
            int a = numList.remove(i);
            List<List<Integer>> getTriplet = getTriplet(a, numList);
            listOfTriplets.addAll(getTriplet);
            numList.add(i, a);
        }
        return removeDuplicates(listOfTriplets);
    }

    /**
     * Three sum optimized list.
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> threeSumOptimized(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> listOfTripletsFormingZero = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int number = -nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    List<Integer> triplet = new ArrayList<>();
                    if (nums[l] + nums[r] == number) {
                        triplet.addAll(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < number) {
                        l++;
                    } else {
                        r--;
                    }
                    if (!triplet.isEmpty())
                        listOfTripletsFormingZero.add(triplet);
                }
            }
        }
        return listOfTripletsFormingZero;
    }
}