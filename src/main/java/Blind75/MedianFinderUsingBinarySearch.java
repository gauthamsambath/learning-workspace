package Blind75;

import java.util.*;

public class MedianFinderUsingBinarySearch {

    List<Integer> listOfNumbers;

    public MedianFinderUsingBinarySearch() {
        this.listOfNumbers = new ArrayList<>();
    }

    public static void main(String[] args) {
        String[] stepArray = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
        int[][] numbersArray = {{}, {2}, {1}, {}, {3}, {}};
        Double[] outputArray = findMedianFromDataStream(stepArray, numbersArray);
        System.out.println("Output Array is given by = " + Arrays.toString(outputArray));
    }

    private static Double[] findMedianFromDataStream(String[] stepArray, int[][] numbersArray) {
        MedianFinderUsingBinarySearch medianFinder = new MedianFinderUsingBinarySearch();
        Double[] outputArray = new Double[stepArray.length];
        for (int i = 0; i < stepArray.length; i++) {
            boolean outputArrayEnteredFlag = false;
            switch (stepArray[i]) {
                case "MedianFinder":
                    medianFinder = new MedianFinderUsingBinarySearch();
                    break;
                case "addNum":
                    medianFinder.addNum(numbersArray[i][0]);
                    break;
                case "findMedian":
                    double median = medianFinder.findMedian();
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

    public void addNum(int num) {
        if (listOfNumbers.isEmpty())
            listOfNumbers.add(num);
        else {
            int position = Collections.binarySearch(listOfNumbers,num);
            if (position < 0) {
                position = -(position + 1);
            }
            listOfNumbers.add(position, num);
        }
    }

    public double findMedian() {
        List<Integer> getOrderedList = getListOfNumbers();
        int length = getOrderedList.size();
        if (length % 2 == 0) {
            return (double) (getOrderedList.get((length / 2) - 1) + getOrderedList.get((length / 2))) / 2;
        } else {
            return (double) getOrderedList.get((length / 2));
        }
    }

    public List<Integer> getListOfNumbers() {
        return listOfNumbers;
    }
}
