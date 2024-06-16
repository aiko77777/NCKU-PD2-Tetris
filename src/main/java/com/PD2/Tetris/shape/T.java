package com.PD2.Tetris.shape;

import com.PD2.Tetris.App.Tetris;
import com.PD2.Tetris.block.*;

import java.awt.image.BufferedImage;

public class T extends Tetromino {
	public T() {
		this(5, 0);
	}

	public T(int x, int y) {
		super(x, y);

		stateList = new int[][][]{
			{{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
			{{0, -1}, {-1, 0}, {0, 0}, {0, 1}},
			{{0, -1}, {-1, 0}, {0, 0}, {1, 0}},
			{{0, -1}, {0, 0}, {1, 0}, {0, 1}}
		};
	}

	@Override
	public BufferedImage getImage() {
		return Tetris.T;
	}
}
