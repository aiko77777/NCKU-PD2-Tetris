package com.PD2.Tetris.App;

import com.PD2.Tetris.block.*;
import com.PD2.Tetris.shape.*;
import com.PD2.Tetris.App.Menu;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Tetris extends JPanel {
	// loading pictures
	public static BufferedImage I;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage O;
	public static BufferedImage S;
	public static BufferedImage T;
	public static BufferedImage Z;
	public static BufferedImage background;
	public static Wall wall;

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
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		//平移坐标轴
		g.translate(22, 15);
		System.out.println("draw");
	}
	public void start(){

	}

	public static void main(String[] args) {

		Menu menu=new Menu();
		menu.start_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("game start!!!");
				menu.frame.dispose();
				JFrame game_frame =new JFrame("NCKU Tetris");
				Tetris panel=new Tetris();
				game_frame.setSize(810,940);
				game_frame.setVisible(true);
				game_frame.add(panel);
				//write start() here
			}
		});
	}
}
