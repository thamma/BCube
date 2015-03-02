package com.BCube;

public enum Color {
	Yellow(1, 'Y'), Red(2, 'R'), Green(3, 'G'), White(1, 'W'), Orange(2, 'O'), Blue(
			3, 'B');

	private int axis;
	private char letter;

	Color(int arg0, char arg1) {
		this.axis = arg0;
		this.letter = arg1;
	}

	public char getLetter() {
		return this.letter;
	}

	public boolean sameAxis(Color c) {
		return this.axis == c.axis;
	}
	
	public Color opposite() {
		return Color.values()[(this.ordinal() + 3)%6];
		
	}
}
