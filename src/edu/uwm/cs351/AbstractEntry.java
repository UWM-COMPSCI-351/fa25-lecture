package edu.uwm.cs351;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractEntry<K, V> implements Map.Entry<K,V> {

	@Override
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Map.Entry<?, ?>)) return false;
		Map.Entry<?,?> other = (Map.Entry<?, ?>)obj;
		return Objects.equals(getKey(), other.getKey()) &&
				Objects.equals(getValue(), other.getValue());
	}

	@Override
	public String toString() {
		return getKey() + "=" + getValue();
	}

	
}
