package com.testing;

public class ExceptionsTesting {

    public static void main(String[] args) {
        int value = testExceptions();
        System.out.println("Value = "+value);
    }

    private static int testExceptions() {
        int value = 0;
        try {
            value = 1;
            if (value%2 == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Exception has occured");
            return value;
        } finally {
            System.out.println("Inside finally");
            return value;
        }
    }
}
