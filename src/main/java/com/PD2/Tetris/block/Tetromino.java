package com.PD2.Tetris.block;

import com.PD2.Tetris.shape.*;
import com.PD2.Tetris.App.Tetris;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tetromino {
	private Cell center;
	private int rotateTime;
	protected int[][][] stateList;

	public static Tetromino random() {
		int random = (int) (Math.random() * 7);
		switch (random) {
			case 0:
				return new I();
			case 1:
				return new J();
			case 2:
				return new L();
			case 3:
				return new O();
			case 4:
				return new S();
			case 5:
				return new Z();
			case 6:
				return new T();
			default:
				return null;
		}
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
		if (coincide()) {
			center.moveRight();
		}
	}

	public void moveDown() {
		center.moveDown();
		if (coincide()) {
			center.moveUp();
		}
	}

	public void moveRight() {
		center.moveRight();
		if (coincide()) {
			center.moveLeft();
		}
	}

	public void rotate() {
		rotateTime++;
		if (coincide()) {
			rotateTime--;
		}
	}

	public boolean coincide() {
		int[][] positions = getBlockPositions();
		for (int[] position : positions) {
			int x = position[0];
			int y = position[1];
			if (x == 0 || x == 9 || Tetris.wall.hasBlock(x, y)) {
				return true;
			}
		}
		return false;
	}

	public int getRotateTime() {
		return rotateTime;
	}

	public void paint(Graphics g) {
		BufferedImage image = getImage();
		int[][] blockPositions = getBlockPositions();
		for (int[] position : blockPositions) {
			int x = position[0] * Cell.SIZE;
			int y = position[1] * Cell.SIZE;
			g.drawImage(image, x, y, null);
		}
	}

	public abstract BufferedImage getImage();

	public int[][] getBlockPositions() {
		int[][] temp = stateList[rotateTime % stateList.length];
		int[][] result = new int[4][2];
		for (int i = 0;i < 4;i++) {
			result[i][0] = center.getX() + temp[i][0];
			result[i][1] = center.getY() + temp[i][1];
		}
		return result;
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
