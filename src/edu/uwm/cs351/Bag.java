package edu.uwm.cs351;

import java.util.NoSuchElementException;

public class Bag {
	private static class Node {
		Coin data;
		Node left, right;
		
		Node(Coin d) { data = d; }
	}
	
	private Node root; // only field
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private int doCount(Node r) {
		if (r == null) return 0;
		return 1 + doCount(r.left)+ doCount(r.right); 
	}
	
	public int count() {
		return doCount(root);
	}
	
	private Node doAdd(Node r, Coin c) {
		if (r == null) return new Node(c);
		if (c.getValue() <= r.data.getValue()) {
			r.left = doAdd(r.left, c);
		} else {
			r.right = doAdd(r.right, c);
		}
		return r;
	}
	
	public void add(Coin c) {
		root = doAdd(root, c);
	}
	
	public Coin smallest() {
		Node lag = null;
		for (Node p = root; p != null; p = p.left) {
			lag = p;
		}
		if (lag == null) throw new NoSuchElementException("empty!");
		return lag.data;
	}
	
	private Node doRemoveSmallest(Node r) {
		if (r.left == null) return r.right;
		r.left = doRemoveSmallest(r.left);
		return r;
	}
	
	public Coin remove() {
		Coin result = smallest();
		root = doRemoveSmallest(root);
		return result;
	}
}
