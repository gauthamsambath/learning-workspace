package Blind75;

import java.util.Arrays;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 5;
        ReverseBits reverseBits = new ReverseBits();
        long a = 2684354560L;
        System.out.println((int) a);
        System.out.println("Integer representing the reverse of the binary equivalent of the number " + n + " is " + reverseBits.reverseBits(n));
    }

    public int reverseBits(int n) {
        char[] binaryRepresentation = convertToThirtyTwoBits(Integer.toBinaryString(n).toCharArray());
        System.out.println(Arrays.toString(binaryRepresentation));
        System.out.println(Integer.MAX_VALUE);
        long reverse = 0;

        for (int i = 31; i >= 0; i--) {
            reverse += Math.pow(2, i) * Character.getNumericValue(binaryRepresentation[i]);
        }
        return (int) reverse;
    }

    private char[] convertToThirtyTwoBits(char[] toCharArray) {
        if (toCharArray.length < 32) {
            char[] convertedArray = new char[32];
            int diff = 32 - toCharArray.length;
            for (int i = 0; i < diff; i++) {
                convertedArray[i] = '0';
            }
            for (int i = diff; i < 32; i++) {
                convertedArray[i] = toCharArray[i - diff];
            }
            return convertedArray;
        }
        return toCharArray;
    }
}
