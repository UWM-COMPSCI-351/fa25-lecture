package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<E> extends AbstractCollection<E> {
	private static final int INITIAL_CAPACITY = 1;
	
	private E[] data;
	private int size;
	private int version;
	
	private void ensureCapacity(int needed) {
		if (needed <= data.length) return;
		int newCap = needed;
		if (newCap < data.length*2) newCap = data.length*2;
		E[] newData = makeArray(newCap);
		for (int i=0; i < size; ++i) {
			newData[i] = data[i];
		}
		data = newData;
	}

	@SuppressWarnings("unchecked")
	private E[] makeArray(int newCap) {
		return (E[])new Object[newCap];
	}
	
	public ArrayCollection() {
		data = makeArray(INITIAL_CAPACITY);
	}
	
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		ensureCapacity(size+1);
		data[size] = e;
		++size;
		++version;
		return true;
	}

	@Override // required
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	@Override // required
	public int size() {
		return size;
	}

	@Override
	public E[] toArray() {
		return data; // XXX very bad idea
	}
	
	private class MyIterator implements Iterator<E> {
		int index = -1;
		int colVersion = version;
		
		private void checkVersion() {
			if (colVersion != version) throw new ConcurrentModificationException("stale");
		}
		@Override
		public boolean hasNext() {
			checkVersion();
			return index+1 < size; // XXX: JTB is dubious
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException("no more");
			++index;
			return data[index];
		}
		
	}
}
