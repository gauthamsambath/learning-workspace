package SthuthiProblems;

import java.util.concurrent.atomic.AtomicBoolean;

public class Timer {
    private final AtomicBoolean running;
    private final AtomicBoolean paused;
    private long startTime;
    private long pausedTime;

    public Timer() {
        running = new AtomicBoolean(false);
        paused = new AtomicBoolean(false);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        timer.pause();
        timer.resume();

        System.out.println(timer.getElapsedTime());

    }

    public void start() {
        if (!running.get()) {
            running.set(true);
            startTime = System.currentTimeMillis();
        }
    }

    public void stop() {
        if (running.get()) {
            running.set(false);
        }
    }

    public void pause() {
        if (running.get() && !paused.get()) {
            paused.set(true);
            pausedTime = System.currentTimeMillis();
        }
    }

    public void resume() {
        if (paused.get()) {
            paused.set(false);
            startTime += System.currentTimeMillis() - pausedTime;
        }
    }

    public long getElapsedTime() {
        if (running.get() && !paused.get()) {
            return System.currentTimeMillis() - startTime;
        } else if (running.get() && paused.get()) {
            return pausedTime - startTime;
        } else {
            return 0;
        }
    }


}
