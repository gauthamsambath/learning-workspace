package Practising;

import java.util.Arrays;

/**
 * The type Sorting algorithms.
 */
public class SortingAlgorithms {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayTobeSorted = {5, 12, 8, 3, 9, 7, 1, 11, 6, 2, 10, 4};
        mergeSort(arrayTobeSorted);
        System.out.println("Sorted Array is given by = " + Arrays.toString(arrayTobeSorted));
    }

    /**
     * Merge sort.
     *
     * @param arrayTobeSorted the array tobe sorted
     */
    private static void mergeSort(int[] arrayTobeSorted) {
        if (arrayTobeSorted.length <= 1) {
            return;
        }

        int mid = arrayTobeSorted.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrayTobeSorted.length - mid];

        System.arraycopy(arrayTobeSorted, 0, leftArray, 0, mid);
        System.arraycopy(arrayTobeSorted, mid, rightArray, 0, arrayTobeSorted.length - mid);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arrayTobeSorted, leftArray, rightArray);
    }

    /**
     * Merge.
     *
     * @param arrayTobeSorted the array tobe sorted
     * @param leftArray       the left array
     * @param rightArray      the right array
     */
    private static void merge(int[] arrayTobeSorted, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arrayTobeSorted[k++] = leftArray[i++];
            } else {
                arrayTobeSorted[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            arrayTobeSorted[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arrayTobeSorted[k++] = rightArray[j++];
        }
    }
}
