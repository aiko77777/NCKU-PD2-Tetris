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
    private final int delay = 1000; 
    private Tetromino currentTetromino;
    private Tetromino nextTetromino; 
    private Tetromino holdTetromino;
    private boolean holdUsed;
    private Wall wall;
    private JFrame gameFrame; 
    private scoreEstimate scoreManager;

    public GameController(JFrame frame) {
        this.gameFrame = frame; 
        timer = new Timer();
        isPaused = false;
        holdUsed = false;
        wall = new Wall();
        scoreManager = new scoreEstimate(); 
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        nextTetromino = Tetromino.random(); 
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
        currentTetromino = nextTetromino; 
        nextTetromino = Tetromino.random(); 
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
                    scoreManager.updateScore(linesCleared, 0); // 更新分數
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
            //currentTetromino.moveUp();
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
        gameFrame.dispose(); //關閉遊戲
        // new End_Menu(); // 結束menu
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
        drawNextTetromino(g); 
    }

    public void drawNextTetromino(Graphics g) {
        if (nextTetromino != null) {
            int offsetX = 400; 
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
