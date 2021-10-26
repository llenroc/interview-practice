/**
 * Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents,
 * and one containing all individuals with exactly one known parent.
 * @param pairs [][] parent child
 * @return [][] a list that containts a list with zero parent, and one with 1 parent 
 */
let question1 = (pairs) => {
    let indegree = new Map();
    for (let pair of pairs) {
        let parent = pair[0];
        let child = pair[1];

        if (!indegree.has(parent)) indegree.set(parent, 0);
        indegree.set(child, (indegree.get(child) || 0) + 1);
    }
    let zeroParents = [];
    let oneParents = [];
    indegree.forEach((val, key) => {
        if (val === 0) {
            zeroParents.push(key);
        } else if (val === 1) {
            oneParents.push(key);
        }
    })
    return [zeroParents, oneParents];
}

// let test1 = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [4, 9], [9, 11]];
// console.log(question1(test1));

/**
 * Write a function that takes the graph, as well as two of the individuals in our dataset, 
 * as its inputs and returns true if and only if they share at least one ancestor.
 */



function question2(pairs, A, B) {
    let indegree = new Map();
    let parentMap = new Map();
    for (let pair of pairs) {
        let parent = pair[0];
        let child = pair[1];

        if (!indegree.has(parent)) indegree.set(parent, 0);
        indegree.set(child, (indegree.get(child) || 0) + 1);

        let parentSet = parentMap.get(child) || [];
        parentSet.push(parent);
        parentMap.set(child, parentSet);
    }

    if (indegree.get(A) === 0 || indegree.get(B) === 0) return false;

    let ancestorOfA = new Set();
    getAncestor(A, ancestorOfA);
    let ancestorOfB = new Set();
    getAncestor(B, ancestorOfB);

    for (let el of ancestorOfA) {
        if (ancestorOfB.has(el)) return true;
    }

    return false;

    function getAncestor(child, list) {
        let queue;
        queue = parentMap.get(child);
        list.add(child);

        while (queue.length) {
            let curr = queue.shift();
            list.add(curr);
            let currParents = parentMap.get(curr) || [];
            for (let el of currParents) {
                queue.push(el);
            }
        }
    }
}

let test2 = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [4, 9], [9, 11], [14, 4], [13, 12], [12, 9]];
console.log(question2(test2, 3, 8));
console.log(question2(test2, 5, 8));
console.log(question2(test2, 6, 8));
console.log(question2(test2, 6, 9));
console.log(question2(test2, 1, 3));
console.log(question2(test2, 7, 11));
console.log(question2(test2, 6, 5));
console.log(question2(test2, 5, 6));

