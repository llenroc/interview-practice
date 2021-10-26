/**
 * @param {string[]} words
 * @param {string} pattern
 * @return {string[]}
 */
var findAndReplacePattern = function (words, pattern) {
    let result = [];
    for (let word of words) {
        if (match(word, pattern)) {
            result.push(word);
        }
    }

    return result;

    function match(word, pattern) {
        if (word.length !== pattern.length) return false;

        let wordMap = new Map();
        let patternMap = new Map();

        for (let i = 0; i < word.length; i++) {
            let w = word[i];
            let p = pattern[i];
            if (!wordMap.has(w)) wordMap.set(w, p);
            if (!patternMap.has(p)) patternMap.set(p, w);

            if (wordMap.get(w) !== p || patternMap.get(p) !== w) return false;
        }

        return true;
    }
};

let param1 = ["abc", "deq", "mee", "aqq", "dkd", "ccc"]
let param2 = "abb";
console.log(findAndReplacePattern(param1, param2));