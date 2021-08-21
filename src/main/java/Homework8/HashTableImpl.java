package Homework8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {


    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        public Item<K, V> next;
        public Item<K, V> prev;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            String item = "{" + "key=" + key + ", value=" + value + "}";
            if (next != null) {
                return item + "->" + next;
            } else {
                return item;
            }
        }

    }

    private ArrayList<Item<K, V>> data;

    public HashTableImpl(int capacity) {
        data = new ArrayList<>();
        data.ensureCapacity(capacity * 2);
        for (int i = 0; i < capacity * 2; i++) {
            data.add(null);
        }

    }

    private int size;

    private int hashFunc(K key) {
        return key.hashCode() % data.size();

    }

    private Item<K, V> getItemForKey(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data.get(index);
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    @Override
    public V put(K key, V value) {
        Item<K, V> item = getItemForKey(key);
        if (item != null) {
            V oldValue = item.value;
            item.value = value;
            return oldValue;
        }
        item = new Item<>(key, value);
        int index = hashFunc(key);
        if (data.get(index) != null) {
            item.next = data.get(index);
            item.next.prev = item;
        }
        data.set(index, item);
        size++;
        return null;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        Item<K, V> item = getItemForKey(key);
        return item == null ? null : item.value;
    }


    @Override
    public V remove(K key) {
        Item<K, V> item = getItemForKey(key);
        if (item == null) {
            return null;
        }
        if (item.prev != null) {
            item.prev.next = item.next;
        } else {
            data.set(hashFunc(key), item.next);
        }

        if (item.next != null) {
            item.next.prev = item.prev;
        }
        size--;
        return item.value;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i) == null ? "" : data.get(i).toString();
            System.out.println(i + ": " + s);
        }
        System.out.println("----------------------");
    }
}
