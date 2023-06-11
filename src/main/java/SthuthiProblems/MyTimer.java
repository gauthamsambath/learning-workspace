package SthuthiProblems;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    Timer timer;

    public MyTimer() {
        timer = new Timer();
    }

    public void start(int delay, int interval) {
        timer.schedule(new TimerTask() {
            public void run() {
            }
        }, delay, interval);
    }

    public void stop() {
        timer.cancel();
    }

    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.start(1000, 1000000); // start the timer with a delay of 1000ms and an interval of 2000ms
        System.out.println("gautham");
        timer.stop();
    }
}
