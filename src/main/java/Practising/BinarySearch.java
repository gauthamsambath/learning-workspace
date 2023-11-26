package Practising;

/**
 * The type Binary search.
 */
public class BinarySearch {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayToDoBinarySearch = {1,2,3,4};
        int elementToSearchFor = 1;
        System.out.println("The element " + elementToSearchFor + (checkWhetherElementPresent(arrayToDoBinarySearch, elementToSearchFor) ? " is present" : " is not present") + " in the given array");
    }

    /**
     * Check whether element present boolean.
     *
     * @param arrayToDoBinarySearch the array to do binary search
     * @param elementToSearchFor    the element to search for
     * @return the boolean
     */
    private static boolean checkWhetherElementPresent(int[] arrayToDoBinarySearch, int elementToSearchFor) {
        mergeSortTheArray(arrayToDoBinarySearch);
        return binarySearchForElement(arrayToDoBinarySearch,elementToSearchFor);
    }

    /**
     * Binary search for element boolean.
     *
     * @param arr                the arr
     * @param elementToSearchFor the element to search for
     * @return the boolean
     */
    private static boolean binarySearchForElement(int[] arr, int elementToSearchFor) {
        int first = 0;
        int last = arr.length;
        int mid =0;
        while (first<last){
            mid = (first+last)/2;
            if (arr[mid] == elementToSearchFor)
                return true;
            else if (arr[mid] > elementToSearchFor)
                last = mid-1;
            else
                first = mid+1;
        }
        return false;
    }

    /**
     * Merge sort the array.
     *
     * @param arr the arr
     */
    private static void mergeSortTheArray(int[] arr) {
        if (arr.length <= 1){
            return;
        }

        int mid = arr.length/2;
        int[] firstHalf = new int[mid];
        int[] seondHalf = new int[arr.length -mid];

        System.arraycopy(arr,0,firstHalf,0,firstHalf.length);
        System.arraycopy(arr,mid,seondHalf,0,seondHalf.length);

        mergeSortTheArray(firstHalf);
        mergeSortTheArray(seondHalf);

        mergeBothArrays(arr,firstHalf,seondHalf);

    }

    /**
     * Merge both arrays.
     *
     * @param arr       the arr
     * @param firstHalf the first half
     * @param seondHalf the seond half
     */
    private static void mergeBothArrays(int[] arr, int[] firstHalf, int[] seondHalf) {
        int i = 0, j = 0, k = 0;
        while (i < firstHalf.length && j < seondHalf.length) {
            if (firstHalf[i] < seondHalf[j]){
                arr[k++] = firstHalf[i++];
            }else {
                arr[k++] = seondHalf[j++];
            }
        }

        if (i < firstHalf.length){
            while (i < firstHalf.length){
                arr[k++] = firstHalf[i++];
            }
        }

        if (j < seondHalf.length){
            while (j < seondHalf.length){
                arr[k++] = seondHalf[j++];
            }
        }
    }
}
