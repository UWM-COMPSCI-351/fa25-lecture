package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override // required
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E[] toArray() {
		return data; // XXX very bad idea
	}
}
