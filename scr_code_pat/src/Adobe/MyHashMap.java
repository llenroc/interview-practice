package Adobe;

import java.util.Arrays;

public class MyHashMap<K,V> {

    public static class Node<K,V>{
        final K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value){
            this.key = key;
            this.value =value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    public static final int DEFAULT_CAPACITY = 16;
    public static final double DEFAULT_LOAD_FACTOR = 0.75;

    Node<K,V>[] array;

    private int size;
    private double load_factor;

    public MyHashMap(){
        this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap, double load_factor){
        if(cap <= 0) throw new IllegalArgumentException("Capacity can not be <= 0");
        array = (Node<K, V>[]) new Node[cap];
        this.load_factor = load_factor;
        this.size = 0;
    }

    public synchronized int size()
    {
        // lock
        return this.size;
        // unlock
    }

    public synchronized boolean isEmpty(){
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private int hash(K key){
        int code = key.hashCode();
        return key.hashCode() >= 0? code : -code;
    }

    private int getIndex(K key){
        if(key == null) return 0;
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2){
        return v1 == v2 || v1 != null && v1.equals(v2);

    }

    private boolean equalsKey(K k1, K k2){
        return k1 == k2 || k1 != null && k1.equals(k2);

    }

    public synchronized boolean containsValue(V value){
        if(this.isEmpty()) return false;

        for(Node<K,V> node: array){
            while(node != null){
                if(equalsValue(node.value,value)) return true;
                node = node.next;
            }
        }
        return false;
    }

    public synchronized boolean containsKey(K key){
        if(this.isEmpty()) return false;
        int index = getIndex(key);
        // corresponding bucket
        Node<K,V> node = array[index];

        while(node != null){
            if(equalsKey(node.key,key)) return  true;
        }
        return false;
    }

    private boolean needRehashing(){
        return ((double)size) / array.length >= load_factor;
    }

    private void rehashing(){
        Node<K,V>[] temp = Arrays.copyOf(array,array.length);
        this.array = new Node[temp.length * 2];
        for(Node<K,V> node: temp){
            put(node.key,node.value);
        }
    }

    public synchronized V put(K key, V value){
        // corresponding bucket
        int index = getIndex(key);
        Node<K, V> head = array[index];
        // traverse
        Node<K, V> node = head;
        // ????????????key???????????????map??? ????????????node???value ?????????????????????value
        while(node != null){
            if(equalsKey(node.key, key)){
                V res = node.value;
                node.value = value;
                return res;
            }
            node = node.next;
        }
        // ????????????node????????????map ????????????linkedlist????????????
        Node<K,V> newHead = new Node(key, value);
        newHead.next = head;
        // ?????? size?????????????????????capacity
        array[index] = newHead;
        size++;
        if(needRehashing()){
            rehashing();
        }
        return null;
    }

    public synchronized V get(K key){
        if(isEmpty()) return null;
        int index = getIndex(key);
        // corresponding bucket
        Node<K,V> node = array[index];
        while(node !=null){
            if(equalsKey(node.key, key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public synchronized void remove(K key){

    }


}
