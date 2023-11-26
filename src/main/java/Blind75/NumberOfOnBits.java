package Blind75;

public class NumberOfOnBits {

    public static void main(String[] args) {
        int a = 2;
        NumberOfOnBits numberOfOnBits = new NumberOfOnBits();
        System.out.println("Number of ones in binary representation = " + numberOfOnBits.hammingWeight(a) );
    }

    public int hammingWeight(int n) {
        char[] binaryRepresentation = Integer.toBinaryString(n).toCharArray();
        int numberOfOnes = 0;
        for (int i = 0; i < binaryRepresentation.length; i++) {
            if (binaryRepresentation[i] == '1')
                numberOfOnes++;
        }
        return numberOfOnes;
    }
}
