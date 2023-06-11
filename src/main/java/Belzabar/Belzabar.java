package Belzabar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Belzabar is 19 years old. On this occasion, we formulated the Belzabar Number. A positive integer is a Belzabar number if it can be represented either as (n * (n + 19)) OR (n * (n - 19)), where n is a prime number.
//
//        Write a function named 'is_belzabar_number' which accepts a number as input and determines if it is a Belzabar Number (or not). Input to the function will be a number and the output will be boolean.
//
//        For bonus points,
//        1. Write a function that calculates and prints the count of Belzabar numbers less than or equal to 1 million.
//        2. Write a function that calculates and prints the count of Belzabar numbers from bonus question #1 above that are prime.
//
//        There are additional bonus points for elegance, adequate code comments describing the algorithm(s) used, focus on coding conventions, optimal speed and time complexity and readability.

/**
 * The code provided is for a Java program that checks for "Belzabar" numbers.
 * A positive integer is a Belzabar number if it can be represented either as (n * (n + 19)) OR (n * (n - 19)),
 * where n is a prime number. The program checks if a given number is a Belzabar number and
 * also finds the number of Belzabar numbers and prime Belzabar numbers up to a given limit.
 *
 * @author gautham sambath
 */
public class Belzabar {

    /**
     * This is the main method of the program that tests the belzabar number functionality
     * It prints whether a given number is a belzabar number or not and also the number of belzabar numbers
     * and prime belzabar numbers up to a given limit
     *
     * @param args the command line arguments passed to the program, not used in this method
     */
    public static void main(String[] args) {
        long timeAtStartingMillis = System.currentTimeMillis(); // get the current time in milliseconds at the start of the method
        int num = 42; // initialize a number to be checked for belzabar number
        boolean isBelzabar = is_belzabar_number(num); // check if the given number is a belzabar number
        System.out.println("The number " + num + " is " + (isBelzabar ? "a " : "not a ") + "belzabar number"); // print the result of the belzabar number check
        System.out.println("number of belzabar numbers upto 1 million = " + findNumberOfBelzabarNumbersUptilGivenNumber(1000000, 'n')); // print the number of belzabar numbers up to 1 million
        System.out.println("number of prime belzabar numbers upto 1 million = " + findNumberOfBelzabarNumbersUptilGivenNumber(1000000, 'y')); // print the number of prime belzabar numbers up to 1 million
        long timeAtEndingMillis = System.currentTimeMillis(); // get the current time in milliseconds at the end of the method
        System.out.println("Time taken to run the program in milli seconds = " + (timeAtEndingMillis - timeAtStartingMillis)); // print the time taken to run the program
    }


    /**
     * This method finds the number of Belzabar numbers up to the given upper limit
     * and either returns the count of all Belzabar numbers or only the count of prime Belzabar numbers
     * depending on the value of the 'primeCheck' parameter.
     *
     * @param uptilNumber an int representing the upper limit of numbers to check for Belzabar numbers.
     * @param primeCheck  a char parameter that determines whether to count only prime Belzabar numbers ('y')
     *                    or all Belzabar numbers ('n').
     * @return an int representing the number of Belzabar numbers found up to the given upper limit.
     */
    private static int findNumberOfBelzabarNumbersUptilGivenNumber(int uptilNumber, char primeCheck) {
        int count = 0; // Initialize count variable to 0
        Set<Integer> primeNumberSet = new HashSet<>(); // Initialize an empty HashSet to store prime numbers

        // Loop through all numbers from 0 to uptilNumber-1
        for (int j = 0; j < uptilNumber; j++) {
            // If the current number is a Belzabar number
            if (is_belzabar_number(j)) {
                // If primeCheck is 'n' (not looking for prime numbers)
                if (primeCheck == 'n') {
                    count++; // Increment count by 1
                } else { // Otherwise (if looking for prime numbers)
                    // If the current number is prime (check using checkIfPrime() method)
                    if (checkIfPrime(j, primeNumberSet)) {
                        count++; // Increment count by 1
                    }
                }
            }
        }

        // Return the final count of Belzabar numbers
        return count;
    }


    /**
     * This method checks whether a given number is a Belzabar number.
     * A Belzabar number is defined as a positive integer that satisfies the following condition:
     * (19 + sqrt(361 + 4 * n)) / 2 is an odd integer, where n is the number being checked.
     *
     * @param num an int representing the number to be checked for being a Belzabar number.
     * @return a boolean value that is true if the given number is a Belzabar number, false otherwise.
     */
    private static boolean is_belzabar_number(int num) {
        // Calculate the value that needs to be checked for being a perfect square
        int checkValue = 361 + 4 * num;
        // Check if the value is a perfect square
        boolean isPerfectSquare = checkIfPerfectSquare(checkValue);
        // If the value is a perfect square, check if it satisfies the condition for being a Belzabar number
        if (isPerfectSquare) {
            // Calculate the square root of the value
            int sqrt = (int) Math.sqrt(checkValue);
            // Check if the square root is even (in which case the number cannot be a Belzabar number)
            if (sqrt % 2 == 0) {
                return false;
            } else {
                // If the square root is odd, calculate the four possible values that could satisfy the Belzabar condition
                List<Integer> listOfValuesEligible = Arrays.asList(((-19 + sqrt) / 2), ((-19 - sqrt) / 2), ((19 + sqrt) / 2), ((19 - sqrt) / 2));
                // Check if any of the four values are prime
                return checkIfAnyEligibleValueIsPrime(listOfValuesEligible);
            }
        }
        // If the value is not a perfect square, return false
        return false;
    }

    /**
     * This method checks if any of the given integers are prime by iterating over a list of values and
     * calling the checkIfPrime method on each value.
     *
     * @param listOfValuesEligible a List of integers representing the values to be checked for being prime.
     * @return a boolean value that is true if any of the given values are prime, false otherwise.
     */
    private static boolean checkIfAnyEligibleValueIsPrime(List<Integer> listOfValuesEligible) {
        // Create a Set to store prime numbers that have already been checked
        Set<Integer> primeNumberSet = new HashSet<>();
        // Iterate over the list of values to be checked
        for (Integer value : listOfValuesEligible) {
            // If the value is negative, it cannot be prime so return false
            if (value < 0) {
                return false;
            }
            // Check if the value is prime using the checkIfPrime method, passing in the Set of prime numbers
            if (checkIfPrime(value, primeNumberSet)) {
                return true;
            }
        }
        // If none of the values are prime, return false
        return false;
    }


    /**
     * This method checks if a given integer is prime using a simple algorithm.
     * It first checks if the given integer is in the Set of known prime numbers,
     * and if it is not, it checks if it is divisible by any odd number between 3 and the square root of the value,
     * excluding 2 and any known prime numbers.
     * If it is not divisible by any of those numbers, it is added to the Set of known prime numbers and is considered prime.
     *
     * @param value          an Integer representing the value to be checked for being prime.
     * @param primeNumberSet a Set of Integers representing the set of known prime numbers.
     * @return a boolean value that is true if the given value is prime, false otherwise.
     */
    private static boolean checkIfPrime(Integer value, Set<Integer> primeNumberSet) {
        // Check if the value is already in the Set of known prime numbers, if it is, return true
        if (primeNumberSet.contains(value)) {
            return true;
        }
        // Check if the value is less than or equal to 1, in which case it cannot be prime so return false
        if (value <= 1) {
            return false;
        } else if (value == 2) {
            // Check if the value is equal to 2, which is the only even prime number
            return true;
        } else if (value % 2 == 0) {
            // Check if the value is even, in which case it cannot be prime so return false
            return false;
        }
        // Calculate the square root of the value and iterate over odd numbers from 3 to the square root
        int sqrt = (int) Math.sqrt(value);
        for (int i = 3; i <= sqrt; i += 2) {
            // Check if the value is divisible by the current odd number, if it is, return false
            if (value % i == 0) {
                return false;
            }
        }
        // If the value is not divisible by any odd numbers up to its square root, it is prime
        // Add the value to the Set of known prime numbers and return true
        primeNumberSet.add(value);
        return true;
    }


    /**
     * This method checks if a given integer is a perfect square or not
     *
     * @param checkValue an integer value to be checked if it's a perfect square
     * @return true if the given integer is a perfect square, false otherwise
     */
    private static boolean checkIfPerfectSquare(int checkValue) {
        double squareRoot = Math.sqrt(checkValue); // calculate the square root of the given integer
        return squareRoot == (int) squareRoot; // check if the square root is an integer or not
        // if the square root is an integer, then it's a perfect square and return true,
        // otherwise, it's not a perfect square and return false
    }


}
