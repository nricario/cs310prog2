package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.IMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class BalancedMap<K, V> implements IMap {
	TreeMap<K, V> map;
	public BalancedMap() {
		map = new TreeMap<K, V>();
	}

	@Override
	public boolean contains(Comparable key) {
		return map.containsKey(key);
	}

	@Override
	public boolean add(Comparable key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object delete(Comparable key) {
		return map.remove(key);
	}

	@Override
	public Object getValue(Comparable key) {
		return map.get(key);
	}

	@Override
	public Comparable<K> getKey(Object value) {
		Iterator<K> keyIter = map.keySet().iterator();
		Iterator<V> valueIter = map.values().iterator();
		while (keyIter.hasNext()) {
			Object tempV = valueIter.next();
			if (tempV.equals(value)) {
				Comparable<K> tempV2 = (Comparable<K>) tempV;
				return tempV2;
			}
		}
		return (Comparable<K>) map.get(value);
	}
		

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> getKeys(Object value) {
		return (Iterable<K>) map.get(value);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Iterable<K> keyset() {
		return map.keySet();
	}

	@Override
	public Iterable<V> values() {
		return map.values();
	}

}
