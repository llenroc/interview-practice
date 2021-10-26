class Node {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class LRU {
  constructor(capacity) {
    this.map = new Map();
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.size = 0;
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  get(key) {}

  put(key, value) {}
}
