/**
 * we first need to count the occurence of each character in the given string.
   Next we use a set to de-duplicate:
we will continue to remove once if there is a duplicate occurence, until 0. 
We do need to add the new occurence to the set if it is not 0.
 */

/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function (s) {
    if (!s || !s.length) return 0;

    // map to record all chat occurance in string
    let map = new Map();
    // use set to record all occurance, in order to dedup
    let set = new Set();
    let removal = 0;

    for (let i = 0; i < s.length; i++) {
        map.set(s[i], (map.get(s[i]) || 0) + 1);
    }

    for (let [key, val] of map) {
        while (set.has(val)) {
            val--;
            removal++;
        }
        if (val !== 0) {
            set.add(val);
        }
    }
    return removal;
};