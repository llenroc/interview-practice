/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */

/*
 BFS
 O(n ^ 2)
 O(n)
 */
function wordBreak1(s, wordDict) {
  let wordSet = new Set(wordDict);
  let queue = [];
  let visited = new Set();
  queue.push(0);
  while (queue.length) {
    let start = queue.shift();
    if (!visited.has(start)) {
      for (let end = start + 1; end <= s.length; end++) {
        if (wordSet.has(s.substring(start, end))) {
          queue.push(end);
          if (end === s.length) {
            return true;
          }
        }
      }
    }
    visited.add(start);
  }
  return false;
}

var wordBreak = function(s, wordDict) {
  //edge case
  if (!wordDict.length) return false;

  // meaning if from [0, i) has dict word
  let set = new Set(wordDict);
  let dp = new Array(s.length).fill(false);
  dp[0] = true;

  for (let i = 1; i <= s.length; i++) {
    for (let j = 0; j < i; j++) {
      if (dp[j] && set.has(s.substring(j, i))) {
        dp[i] = true;
        break;
      }
    }
  }

  return dp[s.length] != null;
};
