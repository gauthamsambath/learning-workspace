package Cognicor;

//Given an array A[] of n numbers and another number x, determines whether or not there exist two elements in A[] whose sum is exactly x.
//
//        Input: arr[] = {0, -1, 2, -3, 1}
//        sum = -2
//        Output: -3, 1
//        If we calculate the sum of the output,
//        1 + (-3) = -2
//
//
//        Input: arr[] = {1, -2, 1, 0, 5}
//        sum = 0
//        Output: -1
//        No valid pair exists.


import java.util.ArrayList;
import java.util.List;

/**
 * The type Number problem cognicor.
 */
public class NumberProblemCognicor {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, -2, 1, 0, 5};
        int sum = 0;
        List<Integer> solutionList = checkIfSumExists(arr,sum);
        System.out.println(solutionList);
     }

    private static List<Integer> checkIfSumExists(int[] arr, int sum) {
        List<Integer> solutionList = new ArrayList<>();
        boolean present = false;
        for (int i = 0 ; i < arr.length ; i ++) {
            for (int j = i+1 ; j < arr.length;j++) {
                if ((arr[i]+arr[j]) == sum){
                    solutionList.add(arr[i]);
                    solutionList.add(arr[j]);
                    present = true;
                }
            }
        }
        if (present == false) {
            solutionList.add(-1);
        }
        return solutionList;
    }

    private static List<Integer> checkIfSumExists2(int[] arr, int sum) {
        List<Integer> solutionList = new ArrayList<>();
        boolean present = false;

        return solutionList;
    }

}
