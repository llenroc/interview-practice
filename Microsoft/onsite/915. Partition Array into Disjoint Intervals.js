/**
 * @param {number[]} A
 * @return {number}
 */
var partitionDisjoint = function (A) {
    let maxLeft = [A[0]];
    let minRight = [A[A.length - 1]];

    let currMax = A[0];
    for (let i = 1; i < A.length; i++) {
        currMax = Math.max(currMax, A[i]);
        maxLeft.push(currMax)
    }

    let currMin = A[A.length - 1];
    for (let i = A.length - 1; i >= 0; i--) {
        currMin = Math.min(currMin, A[i]);
        minRight.unshift(currMin);
    }

    for (let i = 1; i < A.length; i++) {
        if (maxLeft[i - 1] <= minRight[i]) {
            return i;
        }
    }
    return -1;
};