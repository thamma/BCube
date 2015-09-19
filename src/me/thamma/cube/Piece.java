package me.thamma.cube;

public enum Piece {

	UBL(new int[] { 0, 0 }, new int[] { 4, 6 },
			new int[] { 2, 2 } ), UB( new int[] { 0, 1 },
			new int[] { 4, 7 } ), UBR(new int[] {0,2}, new int[] {4,8}, new int[] {5,0} ), UL(new int[] {0,3}, new int[] {2,5}), UR(
			new int[] {0,5}, new int[] {5,3}), UFL(new int[] {0,6}, new int[] {2, 8}, new int[] {1,0}), UF(new int[] {0,7}, new int[] {1,1}), UFR(new int[] {0,8}, new int[] {1,2}, new int[] {5,6}), FL(new int[] {1,3}, new int[] {2,7}), FR(new int[] {1,5}, new int[] {5,7}), BL(new int[] {2,1}, new int[] {4,3}), BR(
			new int[] {4,5}, new int[] {5,1}), DFL(new int[] {1,6}, new int[] {2, 6}, new int[] {3,8}), DF(new int[] {1,7}, new int[] {3,7}), DFR(new int[] {1,8}, new int[] {3,6}, new int[] {5, 8}), DL(new int[] {2,3}, new int[] {3,5}), DR(new int[] {5,5}, new int[] {3, 3}), DBL(new int[] {2,0}, new int[] {3,2}, new int[] {4, 0}), DB(
			new int[] {4,1}, new int[] {3, 1}), DBR(new int[] {4,2}, new int[] {5,2}, new int[] {3,0});
	;

	public int[][] affected;

	Piece(int[]... arg0) {
		this.affected = arg0;
	}

}
