package edu.uwm.cs351;

import java.util.NoSuchElementException;

public class Queue<E> {
	private E[] data;
	private int used;
	
	@SuppressWarnings("unchecked")
	private E[] makeArray(int cap) {
		return (E[])new Object[cap];
	}
	
	public Queue() {
		data = makeArray(1);
		used = 0;
	}
	
	public boolean isEmpty() {
		return used == 0;
	}

	public int size() {
		return used;
	}

	private void ensureCapacity(int needed) {
		if (needed <= data.length) return;
		int newCap = needed;
		if (newCap < data.length*2) newCap = data.length*2;
		E[] newData = makeArray(newCap);
		for (int i=0; i < used; ++i) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public void enqueue(E elem) {
		ensureCapacity(used+1);
		data[used] = elem;
		++used;
	}

	/**
	 * Return the element at the front of the queue.
	 * @return element at front, without removing it.
	 * @exception NoSuchElementException if queue is empty
	 */
	public E front() {
		if (isEmpty()) throw new NoSuchElementException("empty Q");
		return data[0];
	}

	/**
	 * Remove and return the element at the front of the queye
	 * @return former front element
	 * @exception NoSuchElementException if queue is empty
	 */
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException("empty Q");
		E result = data[0];
		--used;
		for (int i=0; i < used; ++i) {
			data[i] = data[i+1];
		}
		return result;
	}

}
