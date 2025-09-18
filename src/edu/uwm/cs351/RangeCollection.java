package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;

public class RangeCollection extends AbstractCollection<Integer> {

	private final int lo, hi;
	
	/**
	 * Create a range from bounds, inclusive/exclusive
	 * @param lo lower inclusive bound
	 * @param hi upper exclusive bound
	 */
	public RangeCollection(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}

	@Override
	public int size() {
		return hi - lo;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyIterator();
	}
	
	/*
	@Override
	public boolean contains(int x) {
		return lo <= x && x < hi;
	}*/
	
	@Override
	public boolean contains(Object o) {
		int x = (Integer)o;
		return lo <= x && x < hi;
	}

	private class MyIterator implements Iterator<Integer> {

		int index = lo-1;
		
		@Override
		public boolean hasNext() {
			return index < hi-1;
		}

		@Override
		public Integer next() {
			++index;
			return index;
		}
		
	}
}
