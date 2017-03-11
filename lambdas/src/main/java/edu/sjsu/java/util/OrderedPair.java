package edu.sjsu.java.util;

/**
 * Created by pjajara on 2/12/17.
 */
public class OrderedPair<K, V> implements Pair {

    K key;
    V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
}
