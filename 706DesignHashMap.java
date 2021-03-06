import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public int get(int key) {
        for(Pair<Integer, Integer> pair : bucket) {
            if(pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;  // in case there is no match.
    }

    /** If the key already exist, but this time the value is different, then update the new value. */
    public void update(int key, int value) {
        boolean found = false;
        for(Pair<Integer, Integer> pair : bucket) {
            if(pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if(!found) {
            bucket.add(new Pair(key, value));
        }
    }

    public void remove(int key) {
        for(Pair<Integer,Integer> pair : bucket) {
            if(pair.first.equals(key)) {
                bucket.remove(pair);
                break;
            }
        }
    }
}

public class MyHashMap {
    private int key_space;
    private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i = 0; i < this.key_space; i++) {
            this.hash_table.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % key_space;
        hash_table.get(hash_key).update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key = key % key_space;
        return hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key = key % key_space;
        hash_table.get(hash_key).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


