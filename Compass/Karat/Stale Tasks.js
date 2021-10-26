class Node {
    constructor() {
        this.timeStamp = null;
        this.children = [];
    }
}

function getStale(steps, execution_times) {
    let treeMap = new Map();
    let result = [];

    for (let pair of steps) {
        if (!treeMap.has(pair[0])) treeMap.set(pair[0], new Node());
        if (!treeMap.has(pair[1])) treeMap.set(pair[1], new Node());


    }
}