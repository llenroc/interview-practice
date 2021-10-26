class Node {
    constructor(key, val) {
        this.key = key;
        this.val = val;
        this.next;
        this.prev;
    }
}

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
    this.map = new Map();
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.size = 0;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    if (!this.map.has(key)) return -1;

    let node = this.map.get(key);
    // update this node's position: delete + move to front(tail)
    this.deleteNode(node);
    this.addToFront(node);
    return node.val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    if (this.map.has(key)) {
        let node = this.map.get(key);
        this.deleteNode(node);
        node.val = value;
        this.addToFront(node);
    } else {
        let newNode = new Node(key, value)
        this.map.set(key, newNode);
        this.addToFront(newNode);
        if (this.size < this.capacity) {
            this.size++;
        } else {
            let tailNode = this.tail.prev;
            this.deleteNode(tailNode);
            this.map.delete(tailNode.key);
        }
    }
};

LRUCache.prototype.deleteNode = function (node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
};


// head - ( newFront ) - oldFront
LRUCache.prototype.addToFront = function (node) {
    this.head.next.prev = node;
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next = node;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */