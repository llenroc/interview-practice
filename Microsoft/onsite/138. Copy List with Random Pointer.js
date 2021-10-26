var copyRandomList = function (head) {
    let map = new Map();
    let curr = head;
    let result = new Node();

    while (curr) {
        if (!map.has(curr)) {
            let newNode = new Node(curr.val);
            map.set(curr, newNode);
        }

        let next = map.get(curr);
        if (curr.random) {
            if (!map.has(curr.random)) {
                let newRandom = new Node(curr.random.val);
                map.set(curr.random, newRandom);
            }
            next.random = map.get(curr.random);
        }

        result.next = next;
        result = result.next;
        curr = curr.next;
    }

    return map.get(head);
};