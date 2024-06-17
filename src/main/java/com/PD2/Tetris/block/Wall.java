package com.PD2.Tetris.block;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Wall {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private final BufferedImage[][] wall;

    public static final int FAIL = -1;
    public static final int LOSE = -2;

    public Wall() {
        wall = new BufferedImage[HEIGHT][WIDTH];
    }

    public boolean hasBlock(int x, int y) {
        return wall[y][x] != null;
    }

    public boolean isFull(int y) {
        for (BufferedImage image : wall[y]) {
            if (image == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int y) {
        for (BufferedImage image : wall[y]) {
            if (image != null) {
                return false;
            }
        }
        return true;
    }

    public int add(Tetromino t) {
        int[][] blockPositions = t.getBlockPositions();
        boolean touchWall = false;

		// check if Tetromino touch the wall
        for (int[] position : blockPositions) {
            int x = position[0];
            int y = position[1];
            if (y == HEIGHT - 1 || hasBlock(x, y + 1)) {
                touchWall = true;
                break;
            }
        }
        if (!touchWall) {
            return FAIL;
        }

		// add image to the right position
        BufferedImage image = t.getImage();
        for (int[] position : blockPositions) {
            int x = position[0];
            int y = position[1];
            wall[y][x] = image;
        }

		// eliminate full lines
        int eliminateLineCount = 0;
        BufferedImage[][] temp = new BufferedImage[HEIGHT][];
        int index = HEIGHT - 1;
        for (int y = HEIGHT - 1; y >= 0; y--) {
            if (isFull(y)) {
                eliminateLineCount++;
            } else {
                temp[index--] = wall[y];
            }
        }

		// squash remain lines
        while (index >= 0) {
            temp[index--] = new BufferedImage[WIDTH];
        }
        for (int y = 0; y < HEIGHT; y++) {
            wall[y] = temp[y];
        }

        if (eliminateLineCount > 0) {
            return eliminateLineCount;
        }

        if (!isEmpty(0)) {
            return LOSE;
        }

        return 0;
    }

    public void paint(Graphics g) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (wall[y][x] != null) {
                    g.drawImage(wall[y][x], x * Cell.SIZE, y * Cell.SIZE, null);
                }
            }
        }
    }

	@Override
	public String toString() {
		String result = "-----\n";
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (wall[y][x] != null) {
					result += "[ ]";
                }
				else {
					result += "   ";
				}
            }
			result += "\n";
        }
		result += "-----\n";
		return result;
	}
}
