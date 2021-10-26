/**
 * @param {string} A
 * @param {string} B
 * @return {string[]}
 * given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.
 */
var uncommonFromSentences = function(A, B) {
  let result = [];
  let wordList = A.concat(' ', B).split(' ');
  let map = new Map();
  for (let word of wordList) {
    let val = map.get(word) || 0;
    map.set(word, val + 1);
  }

  map.forEach((val, key) => {
    if (val === 1) result.push(key);
  });
  return result;
};
