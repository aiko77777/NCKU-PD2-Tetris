package com.PD2.Tetris.App;

public class Timer {
    private long startTime = 0;
    private long currentTime = 0;
    private boolean isRunning = false;

    private long countdownTime = 0;
    private long countdownStartTime = 0;
    private boolean isCountdownRunning = false;

    public void startTimer() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void stopTimer() {
        if (isRunning) {
            currentTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public void resetTimer() {
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

    public boolean haspassed(long durationMillis) {
        return getTime() >= durationMillis;
    }

    public void startCountdownTimer(long countdownMillis) {
        countdownTime = countdownMillis*1000;
        countdownStartTime = System.currentTimeMillis();
        isCountdownRunning = true;
    }

    public void stopCountdownTimer() {
        isCountdownRunning = false;
    }

    public void resetCountdownTimer() {
        countdownTime = 0;
        countdownStartTime = 0;
        isCountdownRunning = false;
    }

    public long getCountdownTime() {
        if (isCountdownRunning) {
            long elapsedTime = System.currentTimeMillis() - countdownStartTime;
            return countdownTime - elapsedTime;
        } else {
            return countdownTime;
        }
    }

    public boolean hasCountdownFinished() {
        return getCountdownTime() <= 0;
    }
}
