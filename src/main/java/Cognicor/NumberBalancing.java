package Cognicor;

//Given a number N in the form of a string, the task is to check whether the given number is balanced or not.
//
//        Examples:
//
//        Input: N = 19091
//        Output: Balanced
//        Explanation:
//        middle element is 0
//        Sum of left half = 1 + 9 = 10
//        Sum of right half = 9 + 1 = 10
//        Hence, the given number is a Balanced number.
//
//        Input: N = 133423
//        Output: Not Balanced
//        Explanation:
//        Sum of left half = 1 + 3 + 3 (7)
//        Sum of right half = 4 + 2 + 3 (9)
//        Hence, the given number is not Balanced

public class NumberBalancing {

    public static void main(String[] args) {
        String number = "19091";
        String number2 = "193193";
        findIfNumberIsBalanced(number2);
    }

    private static void findIfNumberIsBalanced(String number) {
        String[] numberArray = number.split("");
        int length = numberArray.length;
        int mid = numberArray.length/2;
        int sumLeft = 0;
        int sumRight = 0;
//        for (int i = 0, j = length%2 == 0?mid:mid+1; i < mid && j < numberArray.length;i++,j++) {
//            sumLeft+= Integer.parseInt(numberArray[i]);
//            sumRight+= Integer.parseInt(numberArray[j]);
//        }

        mid = length%2 == 0?mid:mid+1;

        for (int i = 0; i < mid && i + mid < length ;i++) {
            sumLeft+= Integer.parseInt(numberArray[i]);
            sumRight+= Integer.parseInt(numberArray[i+mid]);
        }
        System.out.println(sumLeft);
        System.out.println(sumRight);
        if (sumLeft == sumRight) {
            System.out.println("number is balanced");
        } else {
            System.out.println("number is unbalanced");
        }
    }

}
