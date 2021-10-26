/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
    // edge cases
    if (!prerequisites || !prerequisites.length) return true;

    let indegreeMap = new Map();
    let courseMap = new Map();

    for (let pair of prerequisites) {
        let toTake = pair[0];
        let prereq = pair[1];

        indegreeMap.set(toTake, (indegreeMap.get(toTake) || 0) + 1);
        if (!indegreeMap.has(prereq)) indegreeMap.set(prereq, 0);

        if (!courseMap.has(prereq)) {
            let list = [toTake];
            courseMap.set(prereq, list);
        } else {
            let list = courseMap.get(prereq);
            list.push(toTake);
        }
    }

    let queue = [];
    for (let [key, val] of indegreeMap) {
        if (val === 0) queue.push(key);
    }

    while (queue.length) {
        let curr = queue.shift();
        let toTakeList = courseMap.get(curr);

        if (toTakeList) {
            for (let c of toTakeList) {
                let remainCount = indegreeMap.get(c);
                remainCount--;
                indegreeMap.set(c, remainCount)
                if (remainCount === 0) queue.push(c);
            }
        }
    }

    for (let [key, val] of indegreeMap) {
        if (val !== 0) return false;
    }

    return true;
};

function getMiddleCourse(courses) {
    let dependencyMap = new Map(); // key: courseID val: number of dep
    let courseMap = new Map(); // key: course#. val: nextCourse

    for (let course of courses) {
        let prereq = course[0];
        let toTaken = course[1];

        if (!dependencyMap.has(prereq)) dependencyMap.set(prereq, 0);
        dependencyMap.set(toTaken, 1);
        courseMap.set(prereq, toTaken);
    }

    let queue = [];
    let classPath = [];
    let start;

    // find course with no dep
    dependencyMap.forEach((val, key) => {
        if (val === 0) start = key;
    })

    queue.push(start);
    while (queue.length != 0) {
        let curr = queue.shift();
        classPath.push(curr);
        let next = courseMap.get(curr);

        if (next == null) break;
        queue.push(next);
    }

    let mid = Math.floor(classPath.length / 2);
    if (classPath.length % 2 === 0) mid--;
    return classPath[mid];
}


console.log(canFinish(2, [[1, 0]]));