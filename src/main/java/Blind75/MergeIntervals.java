package Blind75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * The type Merge intervals.
 */
public class MergeIntervals {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
//        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = {{1, 10}, {4, 5}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println("Non Overlapping intervals for the given array is = " + Arrays.deepToString(mergeIntervals.merge(arr)));
    }

    /**
     * Merge int [ ] [ ].
     *
     * @param intervals the intervals
     * @return the int [ ] [ ]
     */
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Pair> queueForSortingPairs = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.first, o2.first);
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            Pair pair = new Pair(intervals[i][0], intervals[i][1]);
            queueForSortingPairs.add(pair);
        }
        return getNonOverlappingIntervals(queueForSortingPairs);
    }

    /**
     * Get non overlapping intervals int [ ] [ ].
     *
     * @param queueForSortingPairs the queue for sorting pairs
     * @return the int [ ] [ ]
     */
    private int[][] getNonOverlappingIntervals(PriorityQueue<Pair> queueForSortingPairs) {
        Stack<int[]> stackOfIntervals = new Stack<>();
        while (!queueForSortingPairs.isEmpty()) {
            int[] interval = queueForSortingPairs.poll().getPairs();
            if (stackOfIntervals.isEmpty() || !mergableIntervalsAndPush(interval, stackOfIntervals.peek(), stackOfIntervals))
                stackOfIntervals.push(interval);
        }
        return returnArrayFromStack(stackOfIntervals);
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
        if (peek[1] >= interval[0]) {
            stackOfIntervals.pop();
            stackOfIntervals.push(new int[]{peek[0], Math.max(peek[1], interval[1])});
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return array from stack int [ ] [ ].
     *
     * @param stackOfIntervals the stack of intervals
     * @return the int [ ] [ ]
     */
    private int[][] returnArrayFromStack(Stack<int[]> stackOfIntervals) {
        int sizeOfStack = stackOfIntervals.size();
        int[][] nonOverLappingArray = new int[stackOfIntervals.size()][2];
        for (int i = sizeOfStack - 1; i >= 0; i--) {
            nonOverLappingArray[i] = stackOfIntervals.pop();
        }

        return nonOverLappingArray;
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

