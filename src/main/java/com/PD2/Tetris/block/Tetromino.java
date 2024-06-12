package com.PD2.Tetris.block;

import com.PD2.Tetris.shape.*;

import java.awt.image.BufferedImage;

public abstract class Tetromino {
	private Cell center;
	private int rotateTime;
	protected int[][][] stateList;

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
	}

	public Tetromino(int x, int y) {
		rotateTime = 0;
		center = new Cell(x, y);
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

	public int getRotateTime() {
		return rotateTime;
	}

	public abstract BufferedImage getImage();

	public int[][] getBlockPositions() {
		return stateList[rotateTime % stateList.length];
	}

	@Override
	public String toString() {
		int[][] currentState = stateList[rotateTime % stateList.length];
		int minX, maxX, minY, maxY;
		minX = maxX = currentState[0][0];
		minY = maxY = currentState[0][1];
		for (int[] block : currentState) {
			int x = block[0];
			int y = block[1];
			if (x < minX) {
				minX = x;
			}
			if (y < minY) {
				minY = y;
			}
			if (x > maxX) {
				maxX = x;
			}
			if (y > maxY) {
				maxY = y;
			}
		}
		int width = maxX - minX + 1;
		int height = maxY - minY + 1;
		String empty = "   ";
		String cell = "[ ]";
		String result = center.toString() + "\n";
		int index = 0;
		for (int i = 0;i < height;i++) {
			for (int j = 0;j < width;j++) {
				if (j == currentState[index][0] - minX) {
					result += cell;
					index++;
					if (index == currentState.length) {
						result += "\n";
						return result;
					}
				} else {
					result += empty;
				}
			}
			result += "\n";
		}
		return result;
	}
}
