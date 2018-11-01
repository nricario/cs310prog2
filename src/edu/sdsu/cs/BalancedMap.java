package edu.sdsu.cs;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class BalancedMap implements IMap {
	TreeMap tree;
	public BalancedMap() {
		tree = new TreeMap();
	}


	@Override
	public boolean contains(Comparable key) {
		return tree.containsKey(key);
	}
	

	@Override
	public boolean add(Comparable key, Object value) {
		return tree.put(key, value) != null;
	}

	@Override
	public Object delete(Comparable key) {
		return tree.remove(key) != null;
	}

	@Override
	public Object getValue(Comparable key) {
		// TODO Auto-generated method stub
		return tree.get(key);
	}

	@Override
	public Comparable getKey(Object value) {
		Iterator<Comparable> keyIter = tree.keySet().iterator();
		Iterator<Object> valueIter = tree.values().iterator();
		while (keyIter.hasNext()) {
			Comparable tempK = keyIter.next();
			Object tempV = valueIter.next();
			if (tempV.equals(value))
				return tempK;
		}
		return null;
	}

	@Override
	public Iterable getKeys(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		tree.clear();
	}

	@Override
	public Iterable keyset() {
		for(Map.Entry<Comparable,Object> entry : tree.entrySet()) {
			  Comparable key = entry.getKey();
			  Object value = entry.getValue();

			  System.out.println(key + " => " + value);
			}
	}

	@Override
	public Iterable values() {
		// TODO Auto-generated method stub
		return null;
	}}
