package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.IMap;
import java.util.TreeMap;
import java.util.ArrayList;

public class BalancedMap<K extends Comparable<K>, V> implements IMap {
    TreeMap<K, V> map;

    public BalancedMap() {
        map = new TreeMap<K, V>();
    }

    public BalancedMap(IMap<K, V> imap) {
        map = new TreeMap<K, V>();
        for (K key : imap.keyset()) {
            map.put(key, imap.getValue(key));
        }
    }

    @Override
    public boolean contains(Comparable key) {
        return map.containsKey(key);
    }

    @Override
    public boolean add(Comparable key, Object value) {
        if (map.containsKey(key)) {
            return false;
        }

        V ret = map.put((K) key, (V) value);
        return true;
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
        for (K key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }

        return null;
    }

    @Override
    public Iterable<K> getKeys(Object value) {
        ArrayList<K> keys = new ArrayList<K>();
        for (K key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keys.add(key);
            }
        }
        return keys;
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
