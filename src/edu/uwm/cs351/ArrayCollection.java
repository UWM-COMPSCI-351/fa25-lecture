package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<E> extends AbstractCollection<E> {
	private static final int INITIAL_CAPACITY = 1;
	
	private E[] data;
	private int size;
	
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
		
		@Override
		public boolean hasNext() {
			return index < size; // XXX: JTB is dubious
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException("no more");
			++index;
			return data[index];
		}
		
	}
}
