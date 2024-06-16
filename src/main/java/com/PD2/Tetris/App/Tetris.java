package com.PD2.Tetris.App;

import com.PD2.Tetris.Game.GameController;
import javax.swing.*;

public class Tetris extends JPanel {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start_button.addActionListener(actionEvent -> {
            System.out.println("game start");
            menu.frame.dispose();
            JFrame game_frame = new JFrame("NCKU Tetris");
            GameController gameController = new GameController(game_frame);
            game_frame.setSize(810, 940);
            game_frame.add(gameController);
            game_frame.setVisible(true);
            gameController.start();
        });
    }
}
