package Adobe;

import java.util.*;

public class LRU {
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LRU(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size= 0;
    }

    private void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(Node node){
        node.pre.next= node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if(map.get(key) != null){
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }else{
            Node cur = new Node(key,value);
            map.put(key,cur);
            addToHead(cur);
            if(size < capacity) size++;
            else{
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        }
    }


    class Node{
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
