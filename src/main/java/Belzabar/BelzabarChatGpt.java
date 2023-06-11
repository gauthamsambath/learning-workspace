package Belzabar;

public class BelzabarChatGpt {

    public static void main(String[] args) {
        long timeAtStartingMillis = System.currentTimeMillis();
        int num = 42;
        boolean isBelzabar = is_belzabar_number(num);
        System.out.println("The number " + num + " is " + (isBelzabar ? "a " : "not a ") + "belzabar number");
        count_belzabar_numbers();
        long timeAtEndingMillis = System.currentTimeMillis();
        System.out.println("Time taken to run the program in milli seconds = " + (timeAtEndingMillis - timeAtStartingMillis));
    }

    public static boolean is_prime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean is_belzabar_number(int num) {
        for (int i = 2; i <= Math.sqrt(num + 19); i++) {
            if (is_prime(i)) {
                if (num == i * (i + 19) || num == i * (i - 19)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void count_belzabar_numbers() {
        int belzabar_count = 0;
        int prime_belzabar_count = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (is_belzabar_number(i)) {
                belzabar_count++;
                if (is_prime(i)) {
                    prime_belzabar_count++;
                }
            }
        }
        System.out.println("Total number of Belzabar numbers <= 1,000,000: " + belzabar_count);
        System.out.println("Number of prime Belzabar numbers <= 1,000,000: " + prime_belzabar_count);
    }


}
