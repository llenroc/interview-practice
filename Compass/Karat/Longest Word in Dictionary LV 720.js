/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function (words) {
    let max = '';
    let set = new Set();
    words = words.sort();

    for (let word of words) {
        if (word.length === 1 || set.has(word.substring(0, word.length - 1))) {
            max = word.length > max.length ? word : max;
            set.add(word);
        }
    }
    return max;
};