package com.PD2.Tetris.block;

import com.PD2.Tetris.shape.*;
import java.awt.image.BufferedImage;

public abstract class Tetromino {
	private Cell center;
	private int rotateTime;
	private State[] states;
	private BufferedImage image;

	public static Tetromino random() {
		int random = (int) Math.random() * 7;
		Tetromino t = null;
		switch (random) {
			case 0:
				t = new I();
				break;
			case 1:
				t = new J();
				break;
			case 2:
				t = new L();
				break;
			case 3:
				t = new O();
				break;
			case 4:
				t = new S();
				break;
			case 5:
				t = new Z();
				break;
			case 6:
				t = new I();
				break;
		}
		return t;
	}

	public Tetromino() {
		rotateTime = 0;
		center = new Cell(5, 0);
		states = null;
		image = null;
	}

	public Tetromino(int x, int y) {
		rotateTime = 0;
		center = new Cell(x, y);
		states = null;
		image = null;
	}

	public void moveLeft() {
		center.moveLeft();
	}

	public void moveDown() {
		center.moveDown();
	}

	public void moveRight() {
		center.moveRight();
	}

	public void rotate() {
		rotateTime++;
	}

	public abstract int[][] getBlockPositions();

	class State {
		Cell[] states;

		State(int[][] positions) {
			states = new Cell[4];
			for (int i = 0;i < 4;i++) {
				states[i] = new Cell(positions[i][0], positions[i][1]);
			}
		}
	}
}
