package me.thamma.newcube;

import me.thamma.abstraction.Puzzle;
import me.thamma.cube.Color;

public class Cube3x3 extends Puzzle {

	public Cube3x3(Color[][] stickers) {
		super(stickers);
	}

	public Cube3x3() {
		this(new Color[6][9]);
	}

}
