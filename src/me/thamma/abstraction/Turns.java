package me.thamma.abstraction;

public interface Turns<T extends Puzzle> {

	void apply(T puzzle);

}
