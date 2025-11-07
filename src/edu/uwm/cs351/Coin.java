package edu.uwm.cs351;

public class Coin {
	private final int value;
	private final int year;
	
	public Coin (int v, int y) {
		value = v;
		year = y;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return value + ":" + year;
	}
}
