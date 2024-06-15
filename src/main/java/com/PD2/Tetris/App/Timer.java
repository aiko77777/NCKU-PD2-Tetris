package com.zhao.demo.App;

public class Timer {
    private long startTime;
    private long currentTime;
    private boolean isRunning;

    public Timer() {
        startTime = 0;
        currentTime = 0;
        isRunning = false;
    }

    public void startTimer() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            currentTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public void reset() {
        startTime = 0;
        currentTime = 0;
        isRunning = false;
    }

    public long getTime() {
        if (isRunning) {
            return currentTime + (System.currentTimeMillis() - startTime);
        } else {
            return currentTime;
        }
    }

    public boolean hasPassed(long durationMillis) {
        return getTime() >= durationMillis;
    }
}
