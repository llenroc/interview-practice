/**
 * @param {string[]} words
 * @return {string}
 */

/*
    topological sort
    Time: O(n), assuming 26 const letters appear
    Space: O(n) <= 3 * n  (num of distinct letters)
*/

var alienOrder = function (words) {
    //edge cases
    if (!words || !words.length) return '';
    let result = '';
    let indegree = new Map(); // key: letter, val: num of letter before it
    let outdegree = new Map(); // key:letter, val: set of adjacent letters it aheads from

    //initialize in-degree map
    for (let word of words) {
        for (let i = 0; i < word.length; i++) {
            if (!indegree.has(word[i])) indegree.set(word[i], 0);
        }
    }

    //traverse thru list and compare, build outdegree + update indegree map
    for (let i = 0; i < words.length - 1; i++) {
        let first = words[i];
        let second = words[i + 1];
        let len = Math.min(first.length, second.length);

        for (let j = 0; j < len; j++) {
            const c1 = first[j];
            const c2 = second[j];
            if (c1 !== c2) {
                let set = outdegree.get(c1) || new Set();
                if (!set.has(c2)) {
                    set.add(c2);
                    outdegree.set(c1, set);
                    indegree.set(c2, indegree.get(c2) + 1);
                }
                break;
            }
        }
    }

    //first find the first letter with 0 indegree, then start bfs
    let queue = [];
    indegree.forEach((val, key) => {
        if (val === 0) queue.push(key);
    });

    while (queue.length) {
        let curr = queue.shift();
        result += curr;
        let set = outdegree.get(curr);
        for (let next of set) {
            let val = indegree.get(next);
            val--;
            indegree.set(next, val);
            if (val === 0) queue.push(next);
        }
    }
    // check edge cases, 'zxz' invalid
    if (result.length !== indegree.size) return '';
    return result;
};

const test = ['wrt', 'wrf', 'er', 'ett', 'rftt'];

console.log(alienOrder(test));
