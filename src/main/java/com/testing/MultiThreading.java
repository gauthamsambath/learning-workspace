package com.testing;

public class MultiThreading {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            MultithreadingByThreadClassExtension multithreadingByThreadClassExtension = new MultithreadingByThreadClassExtension();
            multithreadingByThreadClassExtension.start();
        }
    }

}

class MultithreadingByThreadClassExtension extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

class MultiThreadingByImplementingRunnableInterface implements Runnable {

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
