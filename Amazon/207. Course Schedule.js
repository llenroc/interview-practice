/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 * 
 * https://www.youtube.com/watch?v=fskPWs3Nuhc
 * 
 * 
 */
var canFinish = function (numCourses, prerequisites) {
    // # of pre indegree[i] has
    let indegree = new Array(numCourses).fill(0);
    // key: pre val: list of class dependent on this prev
    let graph = new Map();

    for (let i = 0; i < prerequisites.length; i++) {
        let toTake = prerequisites[i][0];
        let prereq = prerequisites[i][1];
        indegree[toTake] = (indegree[toTake] || 0) + 1;
        if (graph.has(prereq)) {
            let list = graph.get(prereq);
            list.push(toTake);
        } else {
            let list = [toTake];
            graph.set(prereq, list);
        }
    }

    let queue = [];
    for (let i = 0; i < numCourses; i++) {
        if (indegree[i] === 0) {
            queue.push(i);
        }
    }

    while (queue.length) {
        let curr = queue.shift();
        let toTakes = graph.get(curr);
        for (let i = 0; toTakes != null && i < toTakes.length; i++) {
            indegree[toTakes[i]]--;
            if (indegree[toTakes[i]] === 0) queue.push(toTakes[i]);
        }
    }

    for (let i = 0; i < numCourses; i++) {
        if (indegree[i] !== 0) return false;
    }
    return true;
};