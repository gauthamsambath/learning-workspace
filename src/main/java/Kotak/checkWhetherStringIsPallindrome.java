package Kotak;

public class checkWhetherStringIsPallindrome {

    public static void main(String[] args) {
        String word = "malayalam";

        char[] wordInArray = word.toCharArray();

        int mid = wordInArray.length / 2;

        boolean isPallindrome = true;

        for (int i = 0, j = wordInArray.length - 1; i <= mid && j > mid; i++, j--) {
            if (wordInArray[i] != wordInArray[j]) {
                isPallindrome = false;
                break;
            }
        }

        System.out.println("the string is " + (isPallindrome ? " a " : " not a ") + "pallindrome");
    }
}
