package com.PD2.Tetris.shape;

import com.PD2.Tetris.App.Tetris;
import com.PD2.Tetris.block.*;

import java.awt.image.BufferedImage;

public class J extends Tetromino {
	public J() {
		this(5, 0);
	}

	public J(int x, int y) {
		super(x, y);

		stateList = new int[][][]{
			{{-1, 0}, {0, 0}, {1, 0}, {1, 1}},
			{{0, -1}, {0, 0}, {-1, 1}, {0, 1}},
			{{-1, -1}, {-1, 0}, {0, 0}, {1, 0}},
			{{0, -1}, {1, -1}, {0, 0}, {0, 1}}
		};
	}

	@Override
	public BufferedImage getImage() {
		return Tetris.J;
	}
}
