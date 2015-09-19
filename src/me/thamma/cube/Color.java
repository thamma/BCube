package me.thamma.cube;

public enum Color {
	Up(1), Front(2), Left(3), Down(1), Back(2), Right(3);

	private final String[] colors = new String[] { "White", "Green", "Orange",
			"Yellow", "Blue", "Red" };

	private int axis;

	Color(int arg0) {
		this.axis = arg0;
	}

	public String toString() {
		return this.colors[this.ordinal()];
	}

	public char getLetter() {
		return this.colors[this.ordinal()].charAt(0);
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
