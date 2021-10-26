/**
 * 
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/414180/Clean-JavaJavaScript-DFS-solution
 * @param {string[]} arr
 * @return {number}
 */
var maxLength = function (arr) {
    let max = 0;
    findMax(0, '');

    return max;

    function findMax(index, concatenatedStr) {
        if (checkUnique(concatenatedStr)) {
            max = Math.max(max, concatenatedStr.length);
        }

        if (index === arr.length || !checkUnique(concatenatedStr)) return;

        for (let i = index; i < arr.length; i++) {
            findMax(i + 1, concatenatedStr + arr[i]);
        }
    }

    function checkUnique(str) {
        return str.length === new Set(str.split('')).size;
    }
};