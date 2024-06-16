package com.PD2.Tetris.shape;

import com.PD2.Tetris.App.Tetris;
import com.PD2.Tetris.block.*;

import java.awt.image.BufferedImage;

public class O extends Tetromino {
	public O() {
		this(5, 0);
	}

	public O(int x, int y) {
		super(x, y);

		stateList = new int[][][]{
			{{-1, 0}, {0, 0}, {-1, 1}, {0, 1}}
		};
	}

	@Override
	public BufferedImage getImage() {
		return Tetris.O;
	}
}
