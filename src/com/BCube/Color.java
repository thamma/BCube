package com.BCube;

public enum Color {
	White(1), Green(2), Orange(3), Yellow(1), Blue(2), Red(3);

	private int axis;

	Color(int arg0) {
		this.axis = arg0;
	}

	public char getLetter() {
		return this.name().charAt(0);
	}

	public boolean sameAxis(Color c) {
		return this.axis == c.axis;
	}

	public boolean adjacient(Color c) {
		return this.axis != c.axis;
	}

	public Color opposite() {
		return Color.values()[(this.ordinal() + 3) % 6];

	}
}
