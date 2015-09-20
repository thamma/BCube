package me.thamma.newcube;

import me.thamma.abstraction.Sticker;
import me.thamma.cube.Color;

public enum Sticker3x3 implements Sticker<Cube3x3> {

	ULB(new int[] { 0, 0 }), UB(new int[] { 0, 1 }), UBR(new int[] { 0, 2 }), UL(new int[] { 0, 3 }), UR(
			new int[] { 0, 5 }), UFL(new int[] { 0, 6 }), UF(new int[] { 0, 7 }), URF(new int[] { 0, 8 }),
	FLU(new int[] {1,0}),FU(new int[] {1,1}),FUR(new int[] {1,2}),FL(new int[] {1,3}),FR(new int[] {1,5}),FDL(new int[] {1,6}),FD(new int[] {1,7}),FRD(new int[] {1,8}),
	LBU(new int[] {2,0}),LU(new int[] {2,1}),LUF(new int[] {2,2}),LB(new int[] {2,3}),LF(new int[] {2,4}),LDB(new int[] {2,5}),LD(new int[] {2,6}),LFD(new int[] {2,7}),
	
	
	;

	private int[] coordinate;

	Sticker3x3(int[] a) {
		this.coordinate = a;
	}

	@Override
	public Color getColor(Cube3x3 puzzle) {
		return puzzle.getColor(this.coordinate[0], this.coordinate[1]);
	}

	@Override
	public int[] getCoordinate() {
		return this.coordinate;
	}

}
