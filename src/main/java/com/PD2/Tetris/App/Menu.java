package com.PD2.Tetris.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {

    JFrame frame;
    JPanel game_title_panel, button_panel, icon_panel;

    JLabel game_title, icon_label;
    JButton start_button, setting_button, leader_board_button;
    Container container;

    Font game_title_font = new Font(null, Font.PLAIN, 100);
    Font button_font = new Font(null, Font.PLAIN, 30);

    ImageIcon icon = new ImageIcon("src/main/java/com/PD2/Tetris/image/UI_image/intro_icon.png");

    public Menu() {
        Color backgroundColor = Color.black; //背景顏色
        Color buttonTextColor = Color.black; // 字的顏色
        Color buttonBackgroundColor = Color.white; // 按鈕顏色
        Color foreColor = Color.white;

        //whole frame
        frame = new JFrame();
        frame.setSize(810, 940);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setLayout(null);
        frame.setVisible(true);

        container = frame.getContentPane();

        //game_title panel
        game_title_panel = new JPanel();
        game_title_panel.setBackground(backgroundColor);
        game_title_panel.setBounds(175, 270, 400, 120);

        //game title
        game_title = new JLabel("Tetris");
        game_title.setForeground(foreColor);
        game_title.setFont(game_title_font);
        game_title_panel.add(game_title);

        //icon panel
        icon_panel = new JPanel();
        icon_panel.setOpaque(false);
        icon_panel.setBounds(300, 60, 200, 200);

        //icon label
        icon.setImage(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        icon_label = new JLabel(icon);
        icon_panel.add(icon_label);

        //start_button_panel
        button_panel = new JPanel();
        button_panel.setBackground(backgroundColor);
        button_panel.setBounds(230, 450, 300, 350);
        button_panel.setLayout(new GridLayout(3, 1));

        //start button
        start_button = new JButton("start");
        start_button.setBackground(buttonBackgroundColor);
        start_button.setForeground(buttonTextColor);
        start_button.setFont(button_font);
        button_panel.add(start_button);


//         start_button.addActionListener(new ActionListener() {   //the start button event
//             @Override
//             public void actionPerformed(ActionEvent actionEvent) {
//                 System.out.println("click start");
//                 new Tetris().startGame(); // 启动游戏
//             }
//         });



//        start_button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                //System.out.println("click start");
//                //put the game start function here
//            }
//        });

        //setting button
        setting_button = new JButton("setting");
        setting_button.setBackground(buttonBackgroundColor);
        setting_button.setForeground(buttonTextColor);

        setting_button.setFont(button_font);
        button_panel.add(setting_button);

        setting_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click setting");

            }
        });

        //leader_board_button
        leader_board_button = new JButton("Leader Board");
        leader_board_button.setBackground(buttonBackgroundColor);
        leader_board_button.setForeground(buttonTextColor);
        leader_board_button.setFont(button_font);
        //button_panel.add(leader_board_button);

        leader_board_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click leader board");

            }
        });

        container.add(icon_panel);//update the UI
        container.add(game_title_panel);
        container.add(button_panel);

        button_panel.validate();
        game_title_panel.validate();
        icon_panel.validate();
    }

    public static void main(String[] args) {
        new Menu();
    }
}
