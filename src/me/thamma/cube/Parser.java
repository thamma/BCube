package me.thamma.cube;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	// reader to parse strings
	private static class Reader {

		private final String data;
		private int index = 0;

		public Reader(String s) {
			this.data = s;
		}

		public boolean available() {
			return index < data.length();
		}

		public char look() {
			if (!available())
				throw new RuntimeException("Unexpected end of input.");
			return data.charAt(index);
		}

		public char read() {
			char value = look();
			index++;
			return value;
		}

		public boolean read(char c) {
			if (c != input.look())
				return false;
			read();
			return true;

		}
	}

	// to process List<Turn> better
	private static class TurnList {
		private List<Turn> l;

		public TurnList() {
			this(new ArrayList<Turn>());
		}

		public TurnList(List<Turn> arg0) {
			l = arg0;
		}

		public TurnList(Algorithm arg0) {
			this(arg0.alg);
		}

		public TurnList(Turn arg0) {
			this();
			append(arg0);
		}

		public TurnList append(Turn arg0) {
			l.add(arg0);
			return this;
		}

		public TurnList append(List<Turn> arg0) {
			l.addAll(arg0);
			return this;
		}

		public TurnList append(TurnList arg0) {
			return append(arg0.getList());
		}

		public List<Turn> getList() {
			return l;
		}

		public TurnList multiply(int arg0) {
			TurnList out = new TurnList();
			for (int i = 0; i < arg0; i++) {
				out.append(this);
			}
			return out;
		}
	}

	public static Reader input;

	// main method
	public static List<Turn> parse(String s) {
		s = s.replaceAll("\\s", "");
		input = new Reader(s);
		return parseExp().getList();
	}

	/* exp ::= exp [exp] | com | alg | ( exp ) [num]
	 * com ::= [exp , exp]
	 * alg ::= turn [alg]
	 * turn::= ...
	 * num ::= ... 
	 * */	
	private static TurnList parseExp() {
		TurnList out = new TurnList();
		while (input.available()) {
			if (input.read('[')) {
				out.append(parseCom());
			} else if (input.read('(')) {
				out.append(parseExp());
			} else if (input.read(']') || input.read(',')) {
				return out;
			} else if (input.read(')')) {
				return out.multiply(parseNum());
			} else if (input.available()
					&& "UFLDBRMES".contains(String.valueOf(input.look()))) {
				out.append(parseTurn());
			} else {
				System.out.println("Could not parse \"" + input.read() + "\"");
			}
		}
		return out;
	}

	private static TurnList parseCom() {
		TurnList a = parseExp();
		if (!input.read(','))
			System.out.println("Syntax error. Could not parse."); // reads ','
		TurnList b = parseExp();
		if (!input.read(']'))
			System.out.println("Syntax error. Could not parse."); // reads ']'
		TurnList ap = new TurnList(new Algorithm(a.getList()).revert());
		TurnList bp = new TurnList(new Algorithm(b.getList()).revert());
		return new TurnList().append(a).append(b).append(ap).append(bp);
	}

	private static TurnList parseTurn() {
		Turn t = Turn.parseTurn(input.read());
		return parseApp(t);
	}

	private static TurnList parseApp(Turn in) {
		if (input.available()
				&& "0123456789i'w".contains(String.valueOf(input.look()))) {
			switch (input.look()) {
			case 'i':
			case '\'':
				input.read();
				return new TurnList(in.prime());
			case 'w':
				input.read();
				return new TurnList(in.wide());
			default:
				return new TurnList(in).multiply(parseNum());
			}
		}
		return new TurnList(in);
	}

	private static int parseNum() {
		String num = "";
		while (input.available()
				&& "0123456789".contains(String.valueOf(input.look()))) {
			num += input.read(); // reads current char
		}
		if (num == "")
			return 1;
		return Integer.valueOf(num);
	}
}
