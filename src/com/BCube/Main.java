package com.BCube;

public class Main {

	public static void main(String[] args) {
		Cube c = new Cube();
		c.printCube();
		c.move(Turn.Up);
		c.move(Turn.Up);
		c.move(Turn.Front);
		c.move(Turn.Front);
		c.move(Turn.Up);
		c.move(Turn.Up);
		c.printCube();
	}

}
