package me.thamma.cube;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

	List<Turn> alg;

	public Algorithm(List<Turn> arg0) {
		this.alg = arg0;
	}
	
	public Algorithm() {
		this(new ArrayList<Turn>());
	}

	public Algorithm(String arg0) {
		this.alg = Parser.parse(arg0);
	}

	public Algorithm times(int i) {
		Algorithm out = new Algorithm(this.alg);
		for (int j = 0; j< i-1; j++) {
			out.append(this.alg);
		}
		return out;
	}
	
	public Algorithm append(String arg0) {
		Algorithm out = new Algorithm(this.alg);
		out.alg.addAll(Parser.parse(arg0));
		return out;
	}

	public Algorithm append(List<Turn> arg0) {
		Algorithm out = new Algorithm(this.alg);
		out.alg.addAll(arg0);
		return out;
	}

	public Algorithm revert() {
		List<Turn> out = new ArrayList<Turn>();
		for(Turn t: this.alg) {
			out.add(0,t.prime());
		}
		return new Algorithm(out);
	}

	public int cycle() {
		int count = 1;
		Cube c = new Cube();
		c.perform(this);
		while (!c.isSolved()) {
			c.perform(this);
			count++;
		}
		return count;
	}

	public boolean affects(PieceOld p) {
		for (int[] a : p.affected) {
			Cube n = new Cube();
			n.perform(this);
			if (!new Cube().stickers[a[0]][a[1]].equals(n.stickers[a[0]][a[1]])) {
				return true;
			}
		}
		return false;
	}

	public List<PieceOld> affected() {
		List<PieceOld> l = new ArrayList<PieceOld>();
		for (PieceOld p : PieceOld.values()) {
			if (affects(p)) {
				l.add(p);
			}
		}
		return l;
	}

	public boolean affectsF2L() {
		for (PieceOld p : affected()) {
			if (!p.name().contains("U"))
				return true;
		}
		return false;
	}

	public static class DB {

		public static class PLL {
			public static Algorithm T = new Algorithm( "R U R' U' R' F R2 U' R' U' R U R' F'");
		}

		public static class OLL {
			public static Algorithm Niklas = new Algorithm("R U' L' U R' U' L U ");
		}

	}
}
