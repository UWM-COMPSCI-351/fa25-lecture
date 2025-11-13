package edu.uwm.cs351;

public class DefaultEntry<K, V> extends AbstractEntry<K, V> {
	private K key;
	private V value;
	
	public DefaultEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override // required
	public K getKey() {
		return key;
	}

	@Override // required
	public V getValue() {
		return value;
	}

	@Override // implementation
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	
}
