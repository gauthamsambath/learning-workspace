package SPGlobal;

public class ArrayChallenge {

    public static String ArrayChallenge(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : arr) {
            largest = Math.max(largest, num);
            sum += num;
        }
        sum -= largest;
        if (sum == largest) {
            return "true";
        }
        for (int i = 0; i < (1 << arr.length ); i++) {
            int currSum = 0;
            for (int j = 0; j < arr.length ; j++) {
                if (((i & (1 << j)) != 0)&&arr[j]!=largest) {
                    currSum += arr[j];
                }
            }
            if (currSum == largest) {
                return "true";
            }
        }
        return "false";
    }

//    0100
//    1010

    public static void main(String[] args) {
        int[] testArray1 = {4, 6, 23, 10, 1, 3};
        int[] testArray2 = {5,7,16,1,2};
        int[] testArray3 = {1, 2, 3, 4, 5, 15};

//        System.out.println(1<<0);

        System.out.println(ArrayChallenge(testArray1)); // Output: "true"
        System.out.println(ArrayChallenge(testArray2)); // Output: "false"
        System.out.println(ArrayChallenge(testArray3)); // Output: "true"
    }
}
