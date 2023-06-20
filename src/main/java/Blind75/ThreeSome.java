package Blind75;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSome {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        ThreeSome threeSome = new ThreeSome();
        System.out.println("The list of triplets forming sum 0 are = " + threeSome.threeSum(nums));
    }

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
}