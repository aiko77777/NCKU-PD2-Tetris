package com.PD2.Tetris.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {

    JFrame frame;
    JPanel game_title_panel,button_panel,icon_panel;

    JLabel game_title,icon_label;
    JButton start_button,setting_button,leader_board_button;
    Container container;    //the basis which can place widgets like panel,buttons.....

    Font game_title_font=new Font(null,Font.PLAIN,100);
    Font button_font=new Font(null,Font.PLAIN,30);

    ImageIcon icon=new ImageIcon("src/main/java/com/PD2/Tetris/image/UI_image/intro_icon.png");


    public Menu(){  //constructor
        Color backgroundColor = Color.black;
        Color foreColor=Color.white;
//whole frame
        frame=new JFrame();
        frame.setSize(810,940);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(backgroundColor);  //bg color


        frame.setLayout(null);  //use absolute coordinates to arrange the layout
        frame.setVisible(true);

        container=frame.getContentPane();   //get the basis
//game_title panel
        game_title_panel=new JPanel();
        game_title_panel.setBackground(backgroundColor);
        game_title_panel.setBounds(175,270,400,120);

//game title
        game_title=new JLabel("Tetris");
        game_title.setForeground(foreColor);
        game_title.setFont(game_title_font);
        game_title_panel.add(game_title);

//icon panel
        icon_panel=new JPanel();
        icon_panel.setOpaque(false);    //make panel invisible ,leave the icon
        icon_panel.setBounds(300,60,200,200);

//icon label
        icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
        icon_label=new JLabel(icon);
        icon_panel.add(icon_label);



//start_button_panel
        button_panel=new JPanel();
        button_panel.setBackground(backgroundColor);
        button_panel.setBounds(230,450,300,350);
        button_panel.setLayout(new GridLayout(3,1));
        //button_panel.setLayout(new GridBagLayout());
        GridBagConstraints space =new GridBagConstraints();
        //space.gridheight=;
        //space.gridweight=;
        //space.insets = new Insets(0, 0, 5, 0);
//start button
        start_button=new JButton("start");
        start_button.setBackground(backgroundColor);
        start_button.setForeground(foreColor);
        start_button.setFont(button_font);
        button_panel.add(start_button);

        start_button.addActionListener(new ActionListener() {   //the start button event
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click start");
                //put the game start function here
            }
        });

//setting button
        setting_button=new JButton("setting");
        setting_button.setBackground(backgroundColor);
        setting_button.setForeground(foreColor);
        setting_button.setFont(button_font);
        button_panel.add(setting_button);

        setting_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click setting");
            }
        });

//leader_board_button
        leader_board_button=new JButton("Leader Board");
        leader_board_button.setBackground(backgroundColor);
        leader_board_button.setForeground(foreColor);
        leader_board_button.setFont(button_font);
        button_panel.add(leader_board_button);

        leader_board_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click leader board");
            }
        });

        container.add(icon_panel);
        container.add(game_title_panel);  //the basis add whole game_title panel includes label
        container.add(button_panel);


        button_panel.validate();    //update the UI
        game_title_panel.validate();
        icon_panel.validate();
    }




    public static void main(String[] args) {
        new Menu();
    }
}
