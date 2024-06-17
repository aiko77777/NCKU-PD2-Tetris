package com.PD2.Tetris.Game;

import com.PD2.Tetris.App.End_Menu;
import com.PD2.Tetris.App.scoreEstimate;
import com.PD2.Tetris.block.Tetromino;
import com.PD2.Tetris.block.Wall;
import com.PD2.Tetris.block.Cell;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class GameController extends JPanel implements KeyListener {
    private Timer timer;
    private boolean isPaused;
    private final int delay = 1000; // 每一秒触发一次
    private Tetromino currentTetromino;
    private Tetromino nextTetromino; // 下一个方块
    private Tetromino holdTetromino;
    private boolean holdUsed;
    private Wall wall;
    private JFrame gameFrame; // 用于在游戏结束时关闭窗口
    private scoreEstimate scoreManager; // 分数管理对象

    public GameController(JFrame frame) {
        this.gameFrame = frame; 
        timer = new Timer();
        isPaused = false;
        holdUsed = false;
        wall = new Wall();
        scoreManager = new scoreEstimate(); // 初始化分数管理对象
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        nextTetromino = Tetromino.random(); // 初始化下一个方块
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {
                    dropCurrentTetromino();
                }
            }
        }, 0, delay);

        spawnNewTetromino();
    }

    public void spawnNewTetromino() {
        currentTetromino = nextTetromino; // 当前方块变为下一个方块
        nextTetromino = Tetromino.random(); // 生成新的下一个方块
        if (wall.add(currentTetromino) == Wall.LOSE) {
            endGame();
        }
        repaint();
    }

    public void dropCurrentTetromino() {
        if (currentTetromino != null) {
            currentTetromino.moveDown();
            if (currentTetromino.coincide()) {
                int linesCleared = wall.add(currentTetromino);
                if (linesCleared > 0) {
                    scoreManager.updateScore(linesCleared, 0); // 更新分数
                }
                holdUsed = false;
                spawnNewTetromino();
            }
            repaint();
        }
    }

    public void moveCurrentTetrominoLeft() {
        if (currentTetromino != null) {
            currentTetromino.moveLeft();
            repaint();
        }
    }

    public void moveCurrentTetrominoRight() {
        if (currentTetromino != null) {
            currentTetromino.moveRight();
            repaint();
        }
    }

    public void rotateCurrentTetromino() {
        if (currentTetromino != null) {
            currentTetromino.rotate();
            repaint();
        }
    }
/*
    public void hardDropCurrentTetromino() {
        if (currentTetromino != null) {
            while (!currentTetromino.coincide()) {
                currentTetromino.moveDown();
            }
            currentTetromino.moveUp();
            int linesCleared = wall.add(currentTetromino);
            if (linesCleared > 0) {
                
            }
            holdUsed = false;
            spawnNewTetromino();
            repaint();
        }
    }
*/
    public void holdCurrentTetromino() {
        if (!holdUsed) {
            if (holdTetromino == null) {
                holdTetromino = currentTetromino;
                spawnNewTetromino();
            } else {
                Tetromino temp = currentTetromino;
                currentTetromino = holdTetromino;
                holdTetromino = temp;
            }
            holdUsed = true;
            repaint();
        }
    }

    public void pause() {
        isPaused = true;
        timer.cancel();
    }

    public void resume() {
        isPaused = false;
        timer = new Timer();
        start();
    }

    public void endGame() {
        // 游戏结束逻辑
        System.out.println("Game Over");
        gameFrame.dispose(); // 关闭当前游戏窗口
        new End_Menu(); // 显示结束菜单
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                moveCurrentTetrominoLeft();
                break;
            case KeyEvent.VK_RIGHT:
                moveCurrentTetrominoRight();
                break;
            case KeyEvent.VK_DOWN:
                dropCurrentTetromino();
                break;
            case KeyEvent.VK_UP:
                rotateCurrentTetromino();
                break;
            case KeyEvent.VK_SPACE:
                // 硬降代码
                // hardDropCurrentTetromino();
                break;
            case KeyEvent.VK_C:
                holdCurrentTetromino();
                break;
            case KeyEvent.VK_P:
                if (isPaused) {
                    resume();
                } else {
                    pause();
                }
                break;
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        wall.paint(g);
        if (currentTetromino != null) {
            currentTetromino.paint(g);
        }
        drawNextTetromino(g); // 绘制下一个方块
    }

    public void drawNextTetromino(Graphics g) {
        if (nextTetromino != null) {
            int offsetX = 400; // 设置下一个方块的显示位置
            int offsetY = 50;
            int[][] blockPositions = nextTetromino.getBlockPositions();
            BufferedImage image = nextTetromino.getImage();
            for (int[] position : blockPositions) {
                int x = position[0] * Cell.SIZE + offsetX;
                int y = position[1] * Cell.SIZE + offsetY;
                g.drawImage(image, x, y, null);
            }
        }
    }
}
