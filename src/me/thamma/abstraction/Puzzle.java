package me.thamma.abstraction;

import me.thamma.cube.Color;

public class Puzzle implements Cloneable {

	private Color[][] stickers;

	public Puzzle(Color[][] stickers) {
		this.clone();
		this.stickers = stickers;
	}

	@Override
	public Puzzle clone() {
		return new Puzzle(stickers.clone());
	}

	public Color getColor(int i, int j) {
		if (this.isValid(i, j))
			return this.stickers[i][j];
		return null;
	}

	private boolean isValid(int i, int j) {
		try {
			@SuppressWarnings("unused")
			Color a = this.stickers[i][j];
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
