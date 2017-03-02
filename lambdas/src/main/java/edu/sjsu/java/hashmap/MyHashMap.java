package edu.sjsu.java.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//http://www.careercup.com/question?id=5132327978008576
public class MyHashMap<K, V> {

    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K k, V v) {
            key = k;
            value = v;
        }
    }

    private int size;
    LinkedList<Pair<K, V>> buckets[];

    public MyHashMap(int size) {
        this.size = size;
        buckets = new LinkedList[this.size];
    }

    public MyHashMap() {
        this.size = 10;
        buckets = new LinkedList[this.size];
    }

    int hash(K key) {
        return key.hashCode() % size;
    }

    void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList();
        }
        for (Pair<K, V> pair : buckets[index]) {
            // Pair<K, V> pair = (Pair<K, V>) p;
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        buckets[index].add(new Pair(key, value));
    }

    V get(K key) {
        int index = hash(key);
        if (buckets[index] == null)
            return null;
        for (Pair<K, V> pair : buckets[index]) {
            // Pair<K, V> pair = (Pair<K, V>) p;
            if (pair.key.equals(key))
                return pair.value;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("CA", "California");
        map.put("TX", "Texas");
        map.put("TX", "Texas1");
        map.put("TX", "Texas2");
        map.put("GA", "Georgia");
        System.out.println(map.get("CA"));
        System.out.println(map.get("TX"));
        System.out.println(map.get("GA"));

        Map m = new HashMap();
        m.put("Yo", "Ram Ram");
        m.remove("Yo");
    }

}
