package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<E> extends AbstractMap<Integer,E> {

	private E[] array;
	
	public ArrayMap(E[] array) {
		this.array = array;
	}
	
	@Override // required
	public Set<Entry<Integer, E>> entrySet() {
		return new EntrySet();
	}

	@Override // efficiency
	public E get(Object key) {
		if (!(key instanceof Integer)) return null;
		Integer i = (Integer)key;
		if (i < 0 || i >= array.length) return null;
		return array[i];
	}

	@Override // implementation
	public E put(Integer key, E value) {
		E result = array[key];
		array[key] = value;
		return result;
	}

	private class EntrySet extends AbstractSet<Entry<Integer, E>> {

		@Override // required
		public int size() {
			return array.length;
		}

		@Override // required
		public Iterator<Entry<Integer, E>> iterator() {
			return new EntrySetIterator();
		}
		
	}
	
	private class EntrySetIterator implements  Iterator<Entry<Integer, E>>{
		int index = -1;
		
		@Override // required 
		public boolean hasNext() {
			return (index+1) < array.length;
		}

		@Override // required
		public Entry<Integer, E> next() {
			if (!hasNext()) throw new NoSuchElementException("no more");
			++index;
			// XXX: The following line is not quite right.
			return new DefaultEntry<Integer,E>(index,array[index]);
		}
		
	}
}
