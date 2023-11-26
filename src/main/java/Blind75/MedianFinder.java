package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The type Median finder.
 */
public class MedianFinder {

    /**
     * The Queue of all integers.
     */
    PriorityQueue<Integer> queueOfAllIntegers;

    /**
     * Instantiates a new Median finder.
     */
    public MedianFinder() {
        this.queueOfAllIntegers = new PriorityQueue<>();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String[] stepArray = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
        int[][] numbersArray = {{}, {2}, {1}, {}, {3}, {}};
        Double[] outputArray = findMedianFromDataStream(stepArray, numbersArray);
        System.out.println("Output Array is given by = " + Arrays.toString(outputArray));
    }

    /**
     * Find median from data stream double [ ].
     *
     * @param stepArray    the step array
     * @param numbersArray the numbers array
     * @return the double [ ]
     */
    private static Double[] findMedianFromDataStream(String[] stepArray, int[][] numbersArray) {
        MedianFinder medianFinder = new MedianFinder();
        Double[] outputArray = new Double[stepArray.length];
        for (int i = 0; i < stepArray.length; i++) {
            boolean outputArrayEnteredFlag = false;
            switch (stepArray[i]) {
                case "MedianFinder":
                    medianFinder = new MedianFinder();
                    break;
                case "addNum":
                    medianFinder.addNum(numbersArray[i][0]);
                    break;
                case "findMedian":
                    double median = medianFinder.findMedianOptimized();
                    outputArray[i] = median;
                    outputArrayEnteredFlag = true;
                    break;
                default:
                    continue;
            }
            if (!outputArrayEnteredFlag)
                outputArray[i] = null;
        }
        return outputArray;
    }

    /**
     * Add num.
     *
     * @param num the num
     */
    public void addNum(int num) {
        getQueueOfAllIntegers().add(num);
    }

    /**
     * Find median double.
     *
     * @return the double
     */
    public double findMedian() {
        PriorityQueue<Integer> queueOfAllIntegersRightNow = getQueueOfAllIntegers();
        int length = queueOfAllIntegersRightNow.size();
        List<Integer> getOrderedList = getOrderedListFromPriorityQueue(queueOfAllIntegersRightNow);
        if (length % 2 == 0) {
            return (double) (getOrderedList.get((length / 2) - 1) + getOrderedList.get((length / 2))) / 2;
        } else {
            return (double) getOrderedList.get((length / 2));
        }
    }
    // still not optimized enough
    public double findMedianOptimized() {
        int length = queueOfAllIntegers.size();
        List<Integer> listOfNumbers = new ArrayList<>();
        PriorityQueue<Integer> duplicate = new PriorityQueue<>(queueOfAllIntegers);
        int middle = length / 2;
        boolean isEvenLength = length % 2 == 0;

        for (int i = 0; i < (isEvenLength ? middle - 1 : middle); i++) {
            duplicate.poll();
        }

        if (!isEvenLength) {
            listOfNumbers.add(duplicate.poll());
        } else {
            listOfNumbers.add(duplicate.poll());
            listOfNumbers.add(duplicate.poll());
        }

        return isEvenLength ? (double) (listOfNumbers.get(0) + listOfNumbers.get(1)) / 2 : listOfNumbers.get(0);
    }

    /**
     * Gets ordered list from priority queue.
     *
     * @param queueOfAllIntegersRightNow the queue of all integers right now
     * @return the ordered list from priority queue
     */
    private List<Integer> getOrderedListFromPriorityQueue(PriorityQueue<Integer> queueOfAllIntegersRightNow) {
        PriorityQueue<Integer> duplicate = new PriorityQueue<>(queueOfAllIntegersRightNow);
        List<Integer> listOfNumbers = new ArrayList<>();
        while (!duplicate.isEmpty()) {
            listOfNumbers.add(duplicate.poll());
        }
        return listOfNumbers;
    }

    /**
     * Gets queue of all integers.
     *
     * @return the queue of all integers
     */
    public PriorityQueue<Integer> getQueueOfAllIntegers() {
        return queueOfAllIntegers;
    }

}
