/**
 * @param {string} s
 * @return {number}
 * sliding window
 * O(n)
 * O(n)
 */
var lengthOfLongestSubstring = function (s) {
    if (!s) return 0;

    let set = new Set();
    let max = 0;
    let start = 0;
    let end = 0;

    while (end < s.length) {
        if (!set.has(s[end])) {
            set.add(s[end]);
            max = Math.max(max, end - start + 1);
            end++;
        } else {
            set.delete(s[start]);
            start++;
        }
    }
    return max;
};
