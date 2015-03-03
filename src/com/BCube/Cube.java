package com.BCube;

public class Cube {

	private Color[][] stickers;

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

//	public void turnU() {
//		movePrime(,
//				);
//	}
	
	public void move(Turn t) {
			move(t.getOrig(), t.getDest());
		}


	public void move(int[][] orig, int[][] dest) {
		//why can't I just 
		//final newcube = stickers.clone() ...
		Color[][] newcube = new Color[6][9];
		for (int i = 0; i<newcube.length;i++) {
			for (int j = 0; j<newcube[i].length;j++) {
				newcube[i][j] = stickers[i][j];
			}
		}
		for (int i = 0; i < orig.length; i++) {
			newcube[dest[i][0]][dest[i][1]] = stickers[orig[i][0]][orig[i][1]];
		}
		stickers = newcube;
	}

	public void printCube() {
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