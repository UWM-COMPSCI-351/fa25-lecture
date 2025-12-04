package edu.uwm.cs351;

import java.util.Collection;
import java.util.Comparator;

public class Quicksort<T> {
	private final Comparator<T> comp;
	public Quicksort(Comparator<T> c) {
		comp = c;
	}
	
	public Collection<T> sort(Collection<T> input) {
		return input;
	}
}
