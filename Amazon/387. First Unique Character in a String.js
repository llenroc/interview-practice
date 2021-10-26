/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    if (!s) return -1;

    let map = new Map();
    for (let i = 0; i < s.length; i++) {
        map.set(s[i], (map.get(s[i]) || 0) + 1);
    }

    for (let i = 0; i < s.length; i++) {
        if (map.get(s[i]) === 1) {
            return i
        }
    }

    return -1;
};