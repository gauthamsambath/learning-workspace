package Blind75;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        int a = 500;
        int b = -500;
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println("sum of " + a + " + " + b + " = " + sumOfTwoIntegers.getSum(a, b));
    }

    public int getSum(int a, int b) {
        char[] aArray = Integer.toBinaryString(a).toCharArray();
        char[] bArray = Integer.toBinaryString(b).toCharArray();

        char[] aIntegerWithTwelvePrecision = getCharArrayWithNinePrecision(aArray);
        char[] bIntegerWithTwelvePrecision = getCharArrayWithNinePrecision(bArray);
        char[] sumArray = getSumWithoutUSingOperands(aIntegerWithTwelvePrecision, bIntegerWithTwelvePrecision);
        int sum = convertBinaryToInteger(sumArray);
        return sum;
    }

    private char[] getSumWithoutUSingOperands(char[] aIntegerWithTwelvePrecision, char[] bIntegerWithTwelvePrecision) {
        char carryForWard = '0';
        char[] sumArray = new char[12];
        for (int i = 11; i >= 0; i--) {
            char[] sumAndCarryArray;
            sumAndCarryArray = getSumAndCarry(aIntegerWithTwelvePrecision[i], bIntegerWithTwelvePrecision[i], carryForWard);
            sumArray[i] = sumAndCarryArray[0];
            carryForWard = sumAndCarryArray[1];
        }
        return sumArray;
    }

    private int convertBinaryToInteger(char[] sumArray) {
        int realInteger = 0;
        int multiplier = 1;
        if (sumArray[0] == '1') {
            multiplier = -1;
            sumArray = revertFromTwoSCompliment(sumArray);
        }
        int pow = 0;

        for (int i = 11; i >= 0; i--) {
            int integer = Integer.parseInt(String.valueOf(sumArray[i]));
            realInteger += integer * (int) Math.pow(2, pow++);
        }
        return multiplier * realInteger;
    }

    private char[] revertFromTwoSCompliment(char[] sumArray) {
        char[] complimentArray = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
        char[] invertedArray = new char[sumArray.length];
        for (int i = 0; i < sumArray.length; i++) {
            invertedArray[i] = sumArray[i] == '0' ? '1' : '0';
        }
        return getSumWithoutUSingOperands(complimentArray, invertedArray);
    }

    private char[] getSumAndCarry(char a, char b, char c) {
        if (a == '0' && b == '0' && c == '0')
            return new char[]{'0', '0'};
        else if (a == '0' && b == '0' && c == '1')
            return new char[]{'1', '0'};
        else if (a == '0' && b == '1' && c == '0')
            return new char[]{'1', '0'};
        else if (a == '1' && b == '0' && c == '0')
            return new char[]{'1', '0'};
        else if (a == '0' && b == '1' && c == '1')
            return new char[]{'0', '1'};
        else if (a == '1' && b == '0' && c == '1')
            return new char[]{'0', '1'};
        else if (a == '1' && b == '1' && c == '0')
            return new char[]{'0', '1'};
        else
            return new char[]{'1', '1'};
    }


    private char[] getCharArrayWithNinePrecision(char[] aArray) {
        char[] arrayWithNinePrecision = new char[12];
        if (aArray.length >= 12) {
            for (int i = 11; i >= 0; i--) {
                arrayWithNinePrecision[i] = aArray[(31 - 11) + i];
            }
        } else {
            int i = 0;
            int len = aArray.length - 1;
            for (i = 11; i >= 12 - aArray.length; i--) {
                arrayWithNinePrecision[i] = aArray[len--];
            }

            while (i >= 0) {
                arrayWithNinePrecision[i--] = '0';
            }
        }
        return arrayWithNinePrecision;
    }
}
