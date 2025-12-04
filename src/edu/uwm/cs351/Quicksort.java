package edu.uwm.cs351;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class Quicksort<T> {
	private final Comparator<T> comp;
	public Quicksort(Comparator<T> c) {
		comp = c;
	}
	
	public Collection<T> sort(Collection<T> input) {
		Collection<T> bigger = new ArrayList<>();
		Collection<T> smaller = new ArrayList<>();
		Iterator<T> it = input.iterator();
		T pivot = it.next();
		while (it.hasNext()) {
			T elem = it.next();
			if (comp.compare(pivot, elem) > 0) {
				smaller.add(elem);
			} else {
				bigger.add(elem);
			}
		}
		bigger = sort(bigger);
		smaller = sort(smaller);
		smaller.add(pivot);
		smaller.addAll(bigger);
		return smaller;
	}
}
