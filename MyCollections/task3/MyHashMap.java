package task3;
import java.util.Arrays;


/**
 * A custom implementation of HashMap using singly linked nodes.
 *
 *@param <K> the type of keys stored in the map
 *@param <V>  the type of values stored in the map
 */
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16; // The default capacity of the hashmap
    private int size; // The number of key-value pairs stored in the hashmap
    private Node<K, V>[] buckets; // An array of nodes, representing the buckets in the hashmap


    /**
     * Implementation of embedded  class Node
     *
     * @param <K> the type of keys stored in the node
     * @param <V> the type of values stored in the node
     */

    private static class Node<K, V> {
        private final K key; // creates ones and never changes
        private V value;
        private Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * method calculate index of bucket using remainder of the division hashcode by number of buckets
     *
     * @param hash hash code of key
     * @return
     */
    private int getIndex(int hash) {
        return Math.abs(hash) % buckets.length;
    }


    /**
     * Constructs a new, empty hashmap with the default capacity.
     */
    public MyHashMap() {

        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new, empty hashmap with the specified capacity.
     *
     * @param capacity the initial capacity of the hashmap
     */
    public MyHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    /**
     * Associates the specified value with the specified key in this map. If the map
     * previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = key.hashCode(); // Calculate the hash code of the key
        int index = getIndex(hash); // Calculate the index of the bucket in which the key-value pair should be stored

        // Check if the key already exists in the bucket
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // If the key already exists, replace the old value with the new one
                return;
            }
            current = current.next;
        }

        // If the key doesn't exist, add a new node to the beginning of the bucket's linked list
        Node<K,V> node = new Node<>(key, value,buckets[index]);
        buckets[index] = node;
        size++;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key the key whose mapping is to be removed from the map
     */
    public void remove(K key) {
        if (key == null) {
            return;
        }
        int hash = key.hashCode(); // Calculate the hash code of the key
        int index = getIndex(hash); // Calculate the index of the bucket in which the key-value pair is stored

        // Search for the node with the specified key in the bucket's linked list
        Node<K, V> prev = null;
        Node<K, V> current = buckets[index]; //entry node in bucket
        while (current != null) {
            if (current.key.equals(key)) {
                // If the node is found, remove it from the linked list
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    /**
     * Removes all of the mappings from this map and reset size to the 0
     */
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }



    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key to looking for V value
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = key.hashCode();
        int index = getIndex(hash);

        Node<K, V> current = buckets[index];
        // look through the linked list
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // if not found return null
    }

    /**
     *
     * @return size of MyHashMap
     */
    public int size(){return size;}
}