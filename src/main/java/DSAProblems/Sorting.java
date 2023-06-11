package DSAProblems;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arrayTobeSorted = {7,8,1,-1,-9,11,20};
        mergeSort(arrayTobeSorted,0,arrayTobeSorted.length-1);
//        System.out.println("array sorted by insertion sort = "+ insertionSort(arrayTobeSorted));
    }

    public static void mergeSort(int[] arrayToBSorted,int beg,int last) {
        int mid = (last+beg)/2;

        if (beg<last) {
            mergeSort(arrayToBSorted,beg,mid);
            mergeSort(arrayToBSorted,mid+1,last);
            merge(arrayToBSorted,beg,mid,last);
        }

        if (last - beg == arrayToBSorted.length-1) {
            System.out.println(Arrays.toString(arrayToBSorted));
        }
    }

    private static void merge(int[] arrayToBSorted, int beg, int mid, int last) {
        int lSize = mid+1-beg;
        int rSize = last - mid;
        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            lArray[i] = arrayToBSorted[beg+i];
        }

        for (int i = 0; i < rSize; i++) {
            rArray[i] = arrayToBSorted[mid+1+i];
        }

        int k = beg;
        int i = 0;
        int j = 0;
        while (i < lSize && j < rSize) {
            if (lArray[i]<rArray[j]) {
                arrayToBSorted[k++] = lArray[i++];
            } else {
                arrayToBSorted[k++] = rArray[j++];
            }
        }

        while (i < lSize) {
            arrayToBSorted[k++] = lArray[i++];
        }

        while (j < rSize) {
            arrayToBSorted[k++] = rArray[j++];
        }

    }


    public  static int[] insertionSort(int[] arrayToBSorted) {
        return new int[3];
    }
}
