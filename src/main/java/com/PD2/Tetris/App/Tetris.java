package com.PD2.Tetris.App;

import com.PD2.Tetris.block.*;
import com.PD2.Tetris.shape.*;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
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

	public static void main(String[] args) {
		new Menu();
	}
}
