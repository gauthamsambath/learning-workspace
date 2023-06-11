package Leetcode;

public class IntegerReverse {
    public static void main(String[] args) {
        int a = +123456789;
        int b = -123456789;

        char[] integerValue = Integer.toString(b).toCharArray();
        char sign = '+';
        int startPosition = 0;
        if (integerValue[0] == '-') {
            startPosition = 1;
            sign = '-';
        }
        StringBuilder reversedInteger = new StringBuilder();
        for (int i = startPosition; i < integerValue.length; i++) {
            reversedInteger.insert(0, integerValue[i]);
        }
        System.out.println("reversed String = " + sign + reversedInteger);
    }

}
