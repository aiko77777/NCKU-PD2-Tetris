package com.PD2.Tetris.App;

import com.PD2.Tetris.Game.GameController;

import javax.swing.JPanel;

public class Tetris extends JPanel {
    public static void main(String[] args) {
        new Menu();
    }

    public void startGame() {
        GameController gameController = new GameController();
        gameController.start();
    }
}
