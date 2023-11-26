package Blind75;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * The type Non over lapping intervals.
 */
public class NonOverLappingIntervals {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] arr2 = {{1, 2},{1, 2},{1, 2}};
        int[][] arr3 = {{1, 2},{2, 3}};
        int[][] arr4 = {{1, 100},{11, 22},{1,11},{2,12}};
        int[][] arr5 = {{0,2},{1,3},{2,4},{3,5},{4,6}};
//        int[][] arr = {{1, 10}, {4, 5}};
        NonOverLappingIntervals nonOverLappingIntervals = new NonOverLappingIntervals();
        System.out.println("Minimum number of elements needed to be removed for making it overlapping is = " + nonOverLappingIntervals.eraseOverlapIntervals(arr5));
    }

    /**
     * Erase overlap intervals int.
     *
     * @param intervals the intervals
     * @return the int
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair> queueForSortingPairs = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (Integer.compare(o1.first, o2.first) == 0){
                    return Integer.compare(o1.last, o2.last);
                }
                return Integer.compare(o1.first, o2.first);
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            Pair pair = new Pair(intervals[i][0], intervals[i][1]);
            queueForSortingPairs.add(pair);
        }
        return getMinNumberOfIntervalsToRemove(queueForSortingPairs);
    }

    /**
     * Gets min number of intervals to remove.
     *
     * @param queueForSortingPairs the queue for sorting pairs
     * @return the min number of intervals to remove
     */
    private int getMinNumberOfIntervalsToRemove(PriorityQueue<Pair> queueForSortingPairs) {
        Stack<int[]> stackOfIntervals = new Stack<>();
        int counter = 0;
        while (!queueForSortingPairs.isEmpty()) {
            int[] interval = queueForSortingPairs.poll().getPairs();
            if (stackOfIntervals.isEmpty()){
                stackOfIntervals.push(interval);
            } else if (mergableIntervalsAndPush(interval, stackOfIntervals.peek(), stackOfIntervals)){
                counter++;
            }

        }
        return counter;
    }

    /**
     * Mergable intervals and push boolean.
     *
     * @param interval         the interval
     * @param peek             the peek
     * @param stackOfIntervals the stack of intervals
     * @return the boolean
     */
    private boolean mergableIntervalsAndPush(int[] interval, int[] peek, Stack<int[]> stackOfIntervals) {
        if (peek[1] > interval[0]) {
            stackOfIntervals.pop();
            if ((peek[1]-peek[0]) <= (interval[1]-interval[0]))
                stackOfIntervals.push(new int[]{peek[0], peek[1]});
            else
                stackOfIntervals.push(new int[]{interval[0], interval[1]});
            return true;
        } else {
            stackOfIntervals.push(new int[]{interval[0], interval[1]});
            return false;
        }
    }

    /**
     * The type Pair.
     */
    class Pair {
        /**
         * The First.
         */
        int first;
        /**
         * The Last.
         */
        int last;
        /**
         * The Pairs.
         */
        int[] pairs;

        /**
         * Instantiates a new Pair.
         *
         * @param first the first
         * @param last  the last
         */
        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
            this.pairs = new int[]{first, last};
        }

        /**
         * Get pairs int [ ].
         *
         * @return the int [ ]
         */
        public int[] getPairs() {
            return pairs;
        }
    }
}
