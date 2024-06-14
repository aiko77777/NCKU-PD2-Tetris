package com.PD2.Tetris.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private boolean isPaused;
    private final int delay = 1000; // 每一秒下降一次

    public GameController() {
        timer = new Timer(delay, this);
        isPaused = false;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void start() {
        timer.start();
    }

    public void pause() {
        isPaused = true;
        timer.stop();
    }

    public void resume() {
        isPaused = false;
        timer.start();
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isPaused) {
            // 方块下降逻辑
            System.out.println("Block is falling");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                // 控制方块左移
                System.out.println("Move Left");
                break;
            case KeyEvent.VK_RIGHT:
                // 控制方块右移
                System.out.println("Move Right");
                break;
            case KeyEvent.VK_DOWN:
                // 控制方块快速下降
                System.out.println("Move Down");
                break;
            case KeyEvent.VK_P:
                if (isPaused) {
                    resume();
                } else {
                    pause();
                }
                break;
            case KeyEvent.VK_Q:
                exit();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
