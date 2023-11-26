package Blind75;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        CountingBits countingBits = new CountingBits();
        System.out.println("Array with count of 1s in all number till n = " + n + " is = " + Arrays.toString(countingBits.countBits(n)));
    }

    public int[] countBits(int n) {
        int[] outputArray = new int[n + 1];
        if (n == 0)
            return new int[]{0};
        else if (n == 1)
            return new int[]{0, 1};
        else if (n == 2)
            return new int[]{0, 1, 1};
        else {
            outputArray[0] = 0;
            outputArray[1] = 1;
            outputArray[2] = 1;
            for (int i = 3; i <= n; i++) {
                if (i % 2 == 0) {
                    outputArray[i] = outputArray[i / 2];
                } else {
                    outputArray[i] = outputArray[i - 1] + 1;
                }
            }
        }

        return outputArray;
    }
}
