package me.thamma.abstraction;

import me.thamma.cube.Color;

public interface Sticker<T extends Puzzle> {
	Color getColor(T puzzle);
	int[] getCoordinate();
}
