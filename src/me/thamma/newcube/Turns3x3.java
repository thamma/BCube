package me.thamma.newcube;

import me.thamma.abstraction.Turns;

public enum Turns3x3 implements Turns<Cube3x3> {

	FRONT(Resource.Front);

	Turns3x3[] turnComposition;
	int[][][] stickerCycle;

	Turns3x3(Turns3x3... turns){
	this.turnComposition = turns;
}

Turns3x3(int[][][] translations) {
		this.stickerCycle = translations;
	}

	@Override
	public void apply(Cube3x3 puzzle) {
		if (turnComposition == null) {
			// TODO apply sticker translation to cube
			for (int i = 0; i < stickerCycle.length; i++) {
				int[][] cycle = stickerCycle[i];

			}
		} else {
			for (Turns3x3 turn : this.turnComposition) {
				turn.apply(puzzle);
			}
		}
	}
}

class Resource {
	public static final int[][][] Front = { {  } };
}
