package com.PD2.Tetris.shape;

import com.PD2.Tetris.App.Tetris;
import com.PD2.Tetris.block.*;

import java.awt.image.BufferedImage;

public class S extends Tetromino {
	public S() {
		this(5, 0);
	}

	public S(int x, int y) {
		super(x, y);

		stateList = new int[][][]{
			{{0, 0}, {1, 0}, {-1, 1}, {0, 1}},
			{{0, -1}, {0, 0}, {1, 0}, {1, 1}}
		};
	}

	@Override
	public BufferedImage getImage() {
		return Tetris.S;
	}
}
