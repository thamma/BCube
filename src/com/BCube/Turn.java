package com.BCube;

public enum Turn {
	Up(new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 },
			new int[] { 0, 2 }, new int[] { 0, 3 }, new int[] { 0, 5 },
			new int[] { 0, 6 }, new int[] { 0, 7 }, new int[] { 0, 8 },
			new int[] { 2, 2 }, new int[] { 2, 5 }, new int[] { 2, 8 },
			new int[] { 4, 6 }, new int[] { 4, 7 }, new int[] { 4, 8 },
			new int[] { 5, 0 }, new int[] { 5, 3 }, new int[] { 5, 6 },
			new int[] { 1, 0 }, new int[] { 1, 1 }, new int[] { 1, 2 }, }, new int[][] { new int[] { 0, 2 }, new int[] { 0, 5 },
					new int[] { 0, 8 }, new int[] { 0, 1 },
					new int[] { 0, 7 }, new int[] { 0, 0 },
					new int[] { 0, 3 }, new int[] { 0, 6 },
					new int[] { 4, 6 }, new int[] { 4, 7 },
					new int[] { 4, 8 }, new int[] { 5, 0 },
					new int[] { 5, 3 }, new int[] { 5, 6 },
					new int[] { 1, 0 }, new int[] { 1, 1 },
					new int[] { 1, 2 }, new int[] { 2, 2 },
					new int[] { 2, 5 }, new int[] { 2, 8 }, })
					,UpPrime(Turn.Up.getDest(), Turn.Up.getOrig()),Front(
							new int[][] {
									new int[]{1,0},
									new int[]{1,1},
									new int[]{1,2},
									new int[]{1,3},
									new int[]{1,5},
									new int[]{1,6},
									new int[]{1,7},
									new int[]{1,8},
									new int[]{3,6},
									new int[]{3,7},
									new int[]{3,8},
									new int[]{2,6},
									new int[]{2,7},
									new int[]{2,8},
									new int[]{0,6},
									new int[]{0,7},
									new int[]{0,8},
									new int[]{5,6},
									new int[]{5,7},
									new int[]{5,8},
							},
							new int[][] {
									new int[]{1,2},
									new int[]{1,5},
									new int[]{1,8},
									new int[]{1,1},
									new int[]{1,7},
									new int[]{1,0},
									new int[]{1,3},
									new int[]{1,6},
									new int[]{2,6},
									new int[]{2,7},
									new int[]{2,8},
									new int[]{0,6},
									new int[]{0,7},
									new int[]{0,8},
									new int[]{5,6},
									new int[]{5,7},
									new int[]{5,8},
									new int[]{3,6},
									new int[]{3,7},
									new int[]{3,8},
							}
							
							
							), 
					
					FrontPrime(Turn.Front.getDest(), Turn.Front.getOrig()),
					Left(     new int[][] {
									new int[]{3,0},
									new int[]{3,1},
									new int[]{3,2},
									new int[]{3,3},
									new int[]{3,5},
									new int[]{3,6},
									new int[]{3,7},
									new int[]{3,8},
									new int[]{1,0},
									new int[]{1,3},
									new int[]{1,6},
									new int[]{3,2},
									new int[]{3,5},
									new int[]{3,8},
									new int[]{4,0},
									new int[]{4,3},
									new int[]{4,6},
									new int[]{0,0},
									new int[]{0,3},
									new int[]{0,6},
									
							},
							new int[][] {
									new int[]{3,2},
									new int[]{3,5},
									new int[]{3,8},
									new int[]{3,1},
									new int[]{3,7},
									new int[]{3,0},
									new int[]{3,3},
									new int[]{3,6},
									new int[]{3,2},
									new int[]{3,5},
									new int[]{3,8},
									new int[]{4,0},
									new int[]{4,3},
									new int[]{4,6},
									new int[]{0,0},
									new int[]{0,3},
									new int[]{0,6},
									new int[]{1,0},
									new int[]{1,3},
									new int[]{1,6},
							}
							), LeftPrime(Turn.Left.getDest(),Turn.Left.getOrig())
							//,Down, Back, Right, Middle, Slice, Equator
					;

	private int[][] orig;
	private int[][] dest;

	Turn(int[][] arg1, int[][] arg2) {
		this.orig = arg1;
		this.dest = arg2;
	}
	
	public int[][] getOrig() {
		return this.orig;
	}
	
	public int[][] getDest() {
		return this.dest;
	}
}
