package com.PD2.Tetris.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class End_Menu {
    Color bg_color = Color.black;
    Color fore_color = Color.white;
    Font button_font = new Font(null, Font.PLAIN, 40);
    Font label_font = new Font(null, Font.PLAIN, 50);
    JFrame end_frame;
    JLabel total_score;
    JButton play_again_button, menu_button;
    Container end_container;

    public End_Menu() {
        // End frame
        end_frame = new JFrame("NCKU Tetris");
        end_frame.setSize(810, 940);
        end_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        end_frame.getContentPane().setBackground(bg_color);  // Background color

        end_frame.setLayout(null);  // Use absolute coordinates to arrange the layout on frame layer including color
        end_frame.setVisible(true);
        end_container = end_frame.getContentPane(); // Get the basis

        // Score label
        int score = 100; // You can pass the actual score here
        Integer score_obj = score;

        total_score = new JLabel("Total score: " + score_obj.toString()); // Need to get the total score in game end
        total_score.setFont(label_font);
        total_score.setForeground(fore_color);
        total_score.setBounds(180, 200, 400, 70);

        // Play again button
        play_again_button = new JButton("Play again");
        play_again_button.setForeground(fore_color);
        play_again_button.setBackground(bg_color);
        play_again_button.setFont(button_font);
        play_again_button.setBounds(100, 750, 250, 70);
        play_again_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Click play again");
                end_frame.dispose();
                new Tetris().main(null);
            }
        });

        // Back to main menu button
        menu_button = new JButton("Menu");
        menu_button.setBackground(bg_color);
        menu_button.setForeground(fore_color);
        menu_button.setFont(button_font);
        menu_button.setBounds(450, 750, 250, 70);
        menu_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Click menu");
                end_frame.dispose();
                new Menu();
            }
        });

        end_container.add(total_score);
        end_container.add(menu_button);
        end_container.add(play_again_button);
        end_container.validate();
    }

    public static void main(String[] args) {
        new End_Menu();
    }
}
