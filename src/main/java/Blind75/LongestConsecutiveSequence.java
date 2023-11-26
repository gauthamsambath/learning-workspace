package Blind75;

import java.util.*;

/**
 * The type Longest consecutive sequence.
 */
public class LongestConsecutiveSequence {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr3 = {1, 2, 0, 1};
        LongestConsecutiveSequence longestCoseq = new LongestConsecutiveSequence();
        System.out.println("Longest Consecutive sequence is given by = " + longestCoseq.longestConsecutiveOpt(arr));
        System.out.println("Longest Consecutive sequence is given by = " + longestCoseq.longestConsecutiveOpt(arr2));
        System.out.println("Longest Consecutive sequence is given by = " + longestCoseq.longestConsecutiveOpt(arr3));
    }

    /**
     * Longest consecutive int.
     *
     * @param nums the nums
     * @return the int
     */
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> sortingElements = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int num : nums) {
            sortingElements.add(num);
        }

        int lengthOfConsecutive = 0;
        Stack<List<Integer>> stackToFindOutLongestConSeq = new Stack<>();

        while (!sortingElements.isEmpty()) {
            int number = sortingElements.poll();
            List<Integer> tempList;
            if (stackToFindOutLongestConSeq.isEmpty()) {
                tempList = new ArrayList<>();
                tempList.add(number);
                stackToFindOutLongestConSeq.add(tempList);
                lengthOfConsecutive = Math.max(lengthOfConsecutive, tempList.size());
            } else {
                tempList = stackToFindOutLongestConSeq.pop();
                if (number == tempList.get(tempList.size() - 1) + 1) {
                    tempList.add(number);
                    stackToFindOutLongestConSeq.add(tempList);
                    lengthOfConsecutive = Math.max(lengthOfConsecutive, tempList.size());
                } else if (number == tempList.get(tempList.size() - 1)) {
                    stackToFindOutLongestConSeq.add(tempList);
                    lengthOfConsecutive = Math.max(lengthOfConsecutive, tempList.size());
                } else {
                    List<Integer> tempList2 = new ArrayList<>();
                    tempList2.add(number);
                    stackToFindOutLongestConSeq.add(tempList);
                    stackToFindOutLongestConSeq.add(tempList2);
                    lengthOfConsecutive = Math.max(lengthOfConsecutive, Math.max(tempList.size(), tempList2.size()));
                }
            }
        }
        return lengthOfConsecutive;
    }

    /**
     * Longest consecutive opt int.
     *
     * @param nums the nums
     * @return the int
     */
    public int longestConsecutiveOpt(int[] nums) {
        Set<Integer> setOfIntegers = new HashSet<>();
        for (int num : nums) {
            setOfIntegers.add(num);
        }
        int lengthOflongConSeq = 0;
        for (Integer num : setOfIntegers) {
            int counter = 0;
            int i = 0;
            if (!setOfIntegers.contains(num - 1)) {
                while (setOfIntegers.contains(num + (i++))) {
                    counter++;
                }
                lengthOflongConSeq = Math.max(lengthOflongConSeq, counter);
            }
        }

        return lengthOflongConSeq;
    }
}
