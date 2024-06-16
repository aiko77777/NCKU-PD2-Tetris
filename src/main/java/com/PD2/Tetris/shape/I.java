package com.PD2.Tetris.shape;

import com.PD2.Tetris.App.Tetris;
import com.PD2.Tetris.block.*;

import java.awt.image.BufferedImage;

public class I extends Tetromino {
	public I() {
		this(5, 0);
	}

	public I(int x, int y) {
		super(x, y);

		stateList = new int[][][]{
			{{-2, 0}, {-1, 0}, {0, 0}, {1, 0}},
			{{0, -2}, {0, -1}, {0, 0}, {0, 1}}
		};
	}

	@Override
	public BufferedImage getImage() {
		return Tetris.I;
	}
}
