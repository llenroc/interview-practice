/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 * 
 * We keep expanding the window by moving the right pointer. 
 * When the window has all the desired characters, 
 * we contract (if possible) and save the smallest window till now.
 */
var minWindow = function (s, t) {
    if (!s || !t) {
        return '';
    }

    let start = 0;
    let end = 0;
    let minLen = Number.MAX_VALUE;
    let map = new Map();
    let ans = '';

    // record all letters in T
    for (let i = 0; i < t.length; i++) {
        let val = map.get(t[i]) || 0;
        map.set(t[i], (map.get(t[i]) || 0) + 1);
    }

    let counter = map.size;
    // start traverse
    while (end < s.length) {
        // find subtr that contains T
        let endChar = s[end];
        if (map.has(endChar)) {
            map.set(endChar, map.get(endChar) - 1);
            if (map.get(endChar) === 0) counter--;
        }
        end++;

        // all t letters found, tighten window
        while (counter === 0) {
            if (end - start < minLen) {
                minLen = end - start;
                ans = s.substring(start, end);
            }

            let startChar = s[start];
            if (map.has(startChar)) {
                map.set(startChar, map.get(startChar) + 1);
                if (map.get(startChar) > 0) counter++;
            }

            start++;
        }
    }
    return ans;
};