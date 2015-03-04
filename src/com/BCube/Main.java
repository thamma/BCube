 package com.BCube;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cube c = new Cube();
		int count = 1;
		List<Turn> al= new ArrayList<Turn>();
		al.add(Turn.Front);
		al.add(Turn.Up);
		al.add(Turn.Left);
		c.perform(al);
		while (!c.isSolved()) {
			c.perform(al);
			count++;
		}
		System.out.println(count);
		System.out.println("Hallo Dominic");
	}

}
 