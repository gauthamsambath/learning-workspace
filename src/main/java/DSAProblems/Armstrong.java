package DSAProblems;

public class Armstrong {

    public static void main(String[] args) {
        int number = 153;
        int dup = number;
        int sum = 0;
        int[] a = new int[3];
        while (dup != 0) {
            int dig = dup % 10;
            sum += dig * dig * dig;
            dup /= 10;
        }

        System.out.println("The number " + number + " " + ((sum == number) ? "is a " : "is not a ") + "armstrong number");
    }
}
