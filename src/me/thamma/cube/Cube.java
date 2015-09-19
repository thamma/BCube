package me.thamma.cube;

import java.util.ArrayList;
import java.util.List;

public class Cube {

	public Color[][] stickers;

	Cube() {
		this.stickers = new Color[6][9];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				this.stickers[i][j] = Color.values()[i];
			}
		}
	}

	Cube(Color[][] c) {
		// hopefully 6x9
		this.stickers = c;
	}

	public Cube clone() {
		return new Cube(stickers);
	}

	public void perform(String s) {
		perform(new Algorithm(s));
	}

	public void perform(Algorithm a) {
		for (Turn t : a.alg) {
			perform(t);
			// printCube();

		}
	}

	public boolean isSolved() {
		for (Color[] side : stickers)
			for (int i = 0; i < side.length; i++)
				if (!side[i].equals(side[4]))
					return false;
		return true;
	}

	public void perform(Turn t) {
		Color[][] newcube = new Color[6][9];
		for (int i = 0; i < newcube.length; i++) {
			for (int j = 0; j < newcube[i].length; j++) {
				newcube[i][j] = stickers[i][j];
			}
		}

		for (int i = 0; i < t.stickers.length; i++) {
			newcube[t.stickers[i][0]][t.stickers[i][1]] = stickers[t.stickers[(i + 12 - t.offset) % 12][0]][t.stickers[(i + 12 - t.offset) % 12][1]];
		}
		if (t.side != -1) {
			int[] res = new int[] { 0, 1, 2, 5, 8, 7, 6, 3 };
			for (int i = 0; i < res.length; i++) {
				newcube[t.side][res[i]] = stickers[t.side][res[(i + 8 - t.sideoffset) % 8]];
			}
		}
		stickers = newcube;
	}

	public void print() {
		for (int i = 0; i < 3; i++) {
			System.out.print(times(8, ' ') + stickers[4][0 + 3 * i].getLetter()
					+ stickers[4][1 + 3 * i].getLetter()
					+ stickers[4][2 + 3 * i].getLetter() + "\n");
		}
		for (int i = 0; i < 3; i++) {
			String res = "3205";
			for (int j = 0; j < 4; j++) {
				int pos = Integer.parseInt("" + res.charAt(j));
				System.out.print("" + stickers[pos][0 + 3 * i].getLetter()
						+ stickers[pos][1 + 3 * i].getLetter()
						+ stickers[pos][2 + 3 * i].getLetter() + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(times(8, ' ') + stickers[1][0 + 3 * i].getLetter()
					+ stickers[1][1 + 3 * i].getLetter()
					+ stickers[1][2 + 3 * i].getLetter() + "\n");
		}
		System.out.println(times(10, "-"));
	}

	public List<Piece> affected() {
		List<Piece> out = new ArrayList<Piece>();
		for (Piece p : Piece.values()) {
			boolean temp = true;
			for (int[] arr : p.affected) {
				if (!stickers[arr[0]][arr[1]]
						.equals(new Cube().stickers[arr[0]][arr[1]]))
					temp = false;
			}
			if (temp == false)
				out.add(p);
		}
		return out;
	}

	public String times(int n, char c) {
		return times(n, "" + c);
	}

	public String times(int n, String c) {
		String out = "";
		for (int i = 0; i < n; i++) {
			out = out + c;
			// out += c;
		}
		return out;
	}

}