package DSAProblems;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    public static void main(String[] args) {
        long timeAtStartingMillis = System.currentTimeMillis();
        long timeAtStartingNano = System.nanoTime();
        int[] arrayOfHeight = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println("Total height of rain water collected = " + trappingRainWater.trap(arrayOfHeight));
        long timeAtEndingMillis = System.currentTimeMillis();
        long timeAtEndingNano = System.nanoTime();
        System.out.println("Time taken to run the program in milli seconds = " + (timeAtEndingMillis - timeAtStartingMillis));
        System.out.println("Time taken to run the program in nano seconds = " + (timeAtEndingNano - timeAtStartingNano));
    }

    public int trap(int[] height) {
        int totalTrappedWater = 0;
        int maxAtLeft = 0;
        int maxAtRight = 0;
        int leftInddex = 0;
        int rightIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (!(height[i] <= maxAtLeft && height[i] <= maxAtRight && i >= leftInddex && i <= rightIndex)) {
                List<Integer> listOfMaxAtLeftAndRight = findMaxAtLeftAndRight(i, height);
                // System.out.println(listOfMaxAtLeftAndRight);
                maxAtLeft = listOfMaxAtLeftAndRight.get(0);
                maxAtRight = listOfMaxAtLeftAndRight.get(1);
            }
            totalTrappedWater += Math.min(maxAtLeft, maxAtRight) - height[i];
        }
        return totalTrappedWater;
    }

    private List<Integer> findMaxAtLeftAndRight(int heightIndex, int[] height) {
        List<Integer> listOfMaxAndIndexAtLeftAndRight = new ArrayList<>();

        int maxAtleft = height[heightIndex];
        int maxAtRight = height[heightIndex];
        int leftIndex = heightIndex;
        int rightIndex = heightIndex;

        for (int i = heightIndex; i >= 0; i--) {
            if (height[i] > maxAtleft) {
                maxAtleft = height[i];
                leftIndex = i;
            }
        }

        for (int i = heightIndex; i < height.length; i++) {
            if (height[i] > maxAtRight) {
                maxAtRight = height[i];
                rightIndex = i;
            }
        }

        listOfMaxAndIndexAtLeftAndRight.add(maxAtleft);
        listOfMaxAndIndexAtLeftAndRight.add(maxAtRight);
        listOfMaxAndIndexAtLeftAndRight.add(leftIndex);
        listOfMaxAndIndexAtLeftAndRight.add(rightIndex);

        return listOfMaxAndIndexAtLeftAndRight;
    }
}
