/**
 * @param {string} digits
 * @return {string[]}
 *
 * we can use backtracking dfs to append all combination recursively
 * Time: O(4^n) n is num of digits
 * Space: O(n)
 */
var letterCombinations = function(digits) {
  if (!digits || digits.length == 0) return [];
  let dict = [
    '0',
    '1',
    'abc',
    'def',
    'ghi',
    'jkl',
    'mno',
    'pqrs',
    'tuv',
    'wxyz'
  ];
  let result = [];

  helper('', digits);
  return result;
  function helper(path, digitStr) {
    if (digitStr.length === 0) {
      result.push(path);
    } else {
      let num = digitStr.substring(0, 1);
      let pattern = dict[num];
      for (let i = 0; i < pattern.length; i++) {
        let tmp = path + pattern.substring(i, i + 1);
        helper(tmp, digitStr.substring(1));
      }
    }
  }
};

// solution II: using a queue, iteratively append
// Time: O(4^n) Space:O(4^n)

var letterCombinations = function(digits) {
  //edge cases
  if (digits == null || digits.length === 0) return [];
  let dict = [
    '0',
    '1',
    'abc',
    'def',
    'ghi',
    'jkl',
    'mno',
    'pqrs',
    'tuv',
    'wxyz'
  ];
  let queue = [];
  queue.push('');

  for (let i = 0; i < digits.length; i++) {
    let index = Number(digits[i]);
    let letters = dict[index];
    while (queue[0].length === i) {
      let curr = queue.shift();
      for (let j = 0; j < letters.length; j++) {
        queue.push(curr + letters[j]);
      }
    }
  }
  return queue;
};
