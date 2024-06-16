package com.PD2.Tetris.block;
import java.awt.Image.*;
import java.awt.image.BufferedImage;

import java.util.Objects;

public class Cell {
	private int x, y;
	public static final int SIZE = 48;

	public Cell() {
		this(0, 0);
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveUp() {
		y--;
	}

	public void moveLeft() {
		x--;
	}

	public void moveDown() {
		y++;
	}

	public void moveRight() {
		x++;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cell))
			return false;
		if (this == o)
			return true;
		Cell temp = (Cell) o;
		return x == temp.getX() && y == temp.getY();
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
