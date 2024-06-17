package com.PD2.Tetris.App;

import com.PD2.Tetris.block.*;
import com.PD2.Tetris.shape.*;
import com.PD2.Tetris.Game.GameController;
import com.PD2.Tetris.block.Tetromino;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.TimerTask;
import java.util.Timer;

import javax.imageio.ImageIO;

public class Tetris extends JPanel {
    private Timer timer;
    private final int delay = 1000; // 每一秒触发一次
    private boolean isPaused;
    private Tetromino currentTetromino;
    private Tetromino nextTetromino; // 下一个方块

    public static  Wall wall;

    private Tetromino holdTetromino;
    private boolean holdUsed;
    //private Wall wall;
    private JFrame gameFrame; // 用于在游戏结束时关闭窗口
    private scoreEstimate scoreManager; // 分数管理对象
    Tetris(){
        nextTetromino = Tetromino.random(); // 初始化下一个方块
        wall=new Wall();
        timer=new Timer();
        isPaused=false;
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //currentTetromino=Tetromino.random();
    }
    // loading pictures
    public static BufferedImage I;
    public static BufferedImage J;
    public static BufferedImage L;
    public static BufferedImage O;
    public static BufferedImage S;
    public static BufferedImage T;
    public static BufferedImage Z;
    public static BufferedImage background;
    //public static Wall wall;

    static {
        try {
            I = ImageIO.read(new File("img/I.png"));
            J = ImageIO.read(new File("img/J.png"));
            L = ImageIO.read(new File("img/L.png"));
            O = ImageIO.read(new File("img/O.png"));
            S = ImageIO.read(new File("img/S.png"));
            T = ImageIO.read(new File("img/T.png"));
            Z = ImageIO.read(new File("img/Z.png"));
            background = ImageIO.read(new File("img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    public void endGame() {
        // 游戏结束逻辑
        System.out.println("Game Over");
        gameFrame.dispose(); // 关闭当前游戏窗口
        new End_Menu(); // 显示结束菜单
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
            System.out.println(currentTetromino.coincide());
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
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
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



    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        // 平移坐标轴
        g.translate(22, 15);
        paintComponent(g);
        drawNextTetromino(g);

        System.out.println("draw");
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("game start!!!");
                menu.frame.dispose();
                JFrame game_frame = new JFrame("NCKU Tetris");
                game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Tetris panel=new Tetris();
                GameController gameController = new GameController(game_frame);
                game_frame.setSize(810, 940);
                game_frame.add(panel);
                //game_frame.add(gameController);
                game_frame.setVisible(true);
                panel.start();
            }
        });
    }
}

//changed coincide add "||y==15"

