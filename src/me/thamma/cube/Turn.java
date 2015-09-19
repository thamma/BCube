package me.thamma.cube;

public enum Turn {

	Up(Resource.Up.res, 3, 0, 2), Front(Resource.Front.res, 3, 1, 2), Left(
			Resource.Left.res, 3, 2, 2), Down(Resource.Down.res, 3, 3, 2), Back(
			Resource.Back.res, 3, 4, 2), Right(Resource.Right.res, 3, 5, 2), UpPrime(
			Resource.Up.res, 9, 0, 6), FrontPrime(Resource.Front.res, 9, 1, 6), LeftPrime(
			Resource.Left.res, 9, 2, 6), DownPrime(Resource.Down.res, 9, 3, 6), BackPrime(
			Resource.Back.res, 9, 4, 6), RightPrime(Resource.Right.res, 9, 5, 6), Middle(
			Resource.Middle.res, 3, -1, 0), Equatorial(Resource.Equatorial.res,
			3, -1, 0), Standing(Resource.Standing.res, 3, -1, 0), MiddlePrime(
			Resource.Middle.res, 9, -1, 0), EquatorialPrime(
			Resource.Equatorial.res, 9, -1, 0), StandingPrime(
			Resource.Standing.res, 9, -1, 0);

	public int[][] stickers;
	public int offset;
	public int side;
	public int sideoffset;

	Turn(int[][] arg0, int arg1, int arg2, int arg3) {
		this.stickers = arg0;
		this.offset = arg1;
		this.side = arg2;
		this.sideoffset = arg3;
	}

	public static Turn parseTurn(char c) {
		switch (c) {
		case 'U':
			return Turn.Up;
		case 'F':
			return Turn.Front;
		case 'L':
			return Turn.Left;
		case 'D':
			return Turn.Down;
		case 'B':
			return Turn.Back;
		case 'R':
			return Turn.Right;
		case 'M':
			return Turn.Middle;
		case 'E':
			return Turn.Equatorial;
		case 'S':
			return Turn.Standing;
		case 'u':
			return Turn.Up.wide();
		case 'f':
			return Turn.Front.wide();
		case 'l':
			return Turn.Left.wide();
		case 'd':
			return Turn.Down.wide();
		case 'b':
			return Turn.Back.wide();
		case 'r':
			return Turn.Right.wide();
		default:
			System.out.println("Could not parse Turn");
			return null;
		}
	}
	
	public Turn wide() {
		System.out.println("Wide turns not implemented yet.");
		return this;
	}

	public Turn prime() {
		switch (this) {
		case Up:
			return UpPrime;
		case Front:
			return FrontPrime;
		case Left:
			return LeftPrime;
		case Down:
			return DownPrime;
		case Back:
			return BackPrime;
		case Right:
			return RightPrime;
		case Middle:
			return MiddlePrime;
		case Equatorial:
			return EquatorialPrime;
		case Standing:
			return StandingPrime;
		case UpPrime:
			return Up;
		case FrontPrime:
			return Front;
		case LeftPrime:
			return Left;
		case DownPrime:
			return Down;
		case BackPrime:
			return Back;
		case RightPrime:
			return Right;
		case MiddlePrime:
			return Middle;
		case EquatorialPrime:
			return Equatorial;
		case StandingPrime:
			return Standing;
		}
		return null;
	}

	private enum Resource {

		Up(new int[][] { new int[] { 1, 2 }, new int[] { 1, 1 },
				new int[] { 1, 0 }, new int[] { 2, 8 }, new int[] { 2, 5 },
				new int[] { 2, 2 }, new int[] { 4, 6 }, new int[] { 4, 7 },
				new int[] { 4, 8 }, new int[] { 5, 0 }, new int[] { 5, 3 },
				new int[] { 5, 6 } }), Front(new int[][] { new int[] { 0, 6 },
				new int[] { 0, 7 }, new int[] { 0, 8 }, new int[] { 5, 6 },
				new int[] { 5, 7 }, new int[] { 5, 8 }, new int[] { 3, 6 },
				new int[] { 3, 7 }, new int[] { 3, 8 }, new int[] { 2, 6 },
				new int[] { 2, 7 }, new int[] { 2, 8 } }), Left(new int[][] {
				new int[] { 0, 0 }, new int[] { 0, 3 }, new int[] { 0, 6 },
				new int[] { 1, 0 }, new int[] { 1, 3 }, new int[] { 1, 6 },
				new int[] { 3, 8 }, new int[] { 3, 5 }, new int[] { 3, 2 },
				new int[] { 4, 0 }, new int[] { 4, 3 }, new int[] { 4, 6 } }), Down(
				new int[][] { new int[] { 2, 0 }, new int[] { 2, 3 },
						new int[] { 2, 6 }, new int[] { 1, 6 },
						new int[] { 1, 7 }, new int[] { 1, 8 },
						new int[] { 5, 8 }, new int[] { 5, 5 },
						new int[] { 5, 2 }, new int[] { 4, 2 },
						new int[] { 4, 1 }, new int[] { 4, 0 } }), Back(
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 1 },
						new int[] { 3, 0 }, new int[] { 2, 2 },
						new int[] { 2, 1 }, new int[] { 2, 0 },
						new int[] { 0, 2 }, new int[] { 0, 1 },
						new int[] { 0, 0 }, new int[] { 5, 2 },
						new int[] { 5, 1 }, new int[] { 5, 0 } }), Right(
				new int[][] { new int[] { 0, 8 }, new int[] { 0, 5 },
						new int[] { 0, 2 }, new int[] { 4, 8 },
						new int[] { 4, 5 }, new int[] { 4, 2 },
						new int[] { 3, 0 }, new int[] { 3, 3 },
						new int[] { 3, 6 }, new int[] { 1, 8 },
						new int[] { 1, 5 }, new int[] { 1, 2 } }), Middle(
				new int[][] { new int[] { 0, 1 }, new int[] { 0, 4 },
						new int[] { 0, 7 }, new int[] { 1, 1 },
						new int[] { 1, 4 }, new int[] { 1, 7 },
						new int[] { 3, 7 }, new int[] { 3, 4 },
						new int[] { 3, 1 }, new int[] { 4, 1 },
						new int[] { 4, 4 }, new int[] { 4, 7 } }), Equatorial(
				new int[][] { new int[] { 1, 3 }, new int[] { 1, 4 },
						new int[] { 1, 5 }, new int[] { 5, 7 },
						new int[] { 5, 4 }, new int[] { 5, 1 },
						new int[] { 4, 5 }, new int[] { 4, 4 },
						new int[] { 4, 3 }, new int[] { 2, 1 },
						new int[] { 2, 4 }, new int[] { 2, 7 }, }), Standing(
				new int[][] { new int[] { 0, 3 }, new int[] { 0, 4 },
						new int[] { 0, 5 }, new int[] { 5, 3 },
						new int[] { 5, 4 }, new int[] { 5, 5 },
						new int[] { 3, 5 }, new int[] { 3, 4 },
						new int[] { 3, 3 }, new int[] { 2, 3 },
						new int[] { 2, 4 }, new int[] { 2, 5 } });
		public int[][] res;

		Resource(int[][] arg0) {
			this.res = arg0;
		}
	}

}
