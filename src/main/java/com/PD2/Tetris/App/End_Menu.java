package com.PD2.Tetris.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class End_Menu {
    Color bg_color=Color.black;
    Color fore_color=Color.white;
    Font button_font=new Font(null,Font.PLAIN,40);
    Font label_font=new  Font(null,Font.PLAIN,50);
    JFrame end_frame;
    JLabel total_score;
    JButton play_again_button,Menu_button;
    Container end_container;
    public End_Menu(){
//end frame
        end_frame=new JFrame("NCKU Trtris");
        end_frame.setSize(810,940);
        end_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        end_frame.getContentPane().setBackground(bg_color);  //bg color

        end_frame.setLayout(null);  //use absolute coordinates to arrange the layout on frame layer including color
        end_frame.setVisible(true);
        end_container=end_frame.getContentPane();//get the basis
//button_panel
//        button_panel=new JPanel();
//        button_panel.setLayout(null);   //the things on button_panel use absolute coordinates
//        button_panel.setBounds(100,150,600,600);


//score label
        int score=100;
        Integer score_obj=(Integer) score;

        total_score=new JLabel("Total score:"+score_obj.toString());   //need to get the total score in game end
        total_score.setFont(label_font);
        total_score.setForeground(fore_color);
        total_score.setBounds(180,200,400,70);

//play_again
        play_again_button=new JButton("play again");
        play_again_button.setForeground(fore_color);
        play_again_button.setBackground(bg_color);
        play_again_button.setFont(button_font);
        play_again_button.setBounds(100,750,250,70);
        //button_panel.add(play_again_button);
        play_again_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click play again");
            }
        });
//back to main_menu
        Menu_button=new JButton("Menu");
        Menu_button.setBackground(bg_color);
        Menu_button.setForeground(fore_color);
        Menu_button.setFont(button_font);
        Menu_button.setBounds(450,750,250,70);
        Menu_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click Menu");
            }
        });

        end_container.add(total_score);
        end_container.add(Menu_button);
        end_container.add(play_again_button);
        end_container.validate();
    }
    public static void main(String[] args){
        new End_Menu();
    }
}
