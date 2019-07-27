package yahoo;

import java.util.HashMap;

public class LRU {

    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;


    public LRU(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
        this.capacity = capacity;
    }

    public void removeNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.get(key) != null){
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            node.val = value;
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
            if(count < capacity) count++;
            else{

                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
