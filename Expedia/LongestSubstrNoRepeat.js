/*

给String比如 "1abc1ab" 
返回 max unique substring(数字可以重复)，即返回 "1abc1"

sliding window 
and set for visited

Time: O(n) <= O(2 * n)    ex:  ' a b c d d e ' 
Space: O(1);  const 26 letters
    a b c d d
            i
            j
*/

function getLongest(str) {
  let i = 0;
  let j = 0;
  let longest = 0;
  let set = new Set();

  while (j < str.length) {
    if (set.has(str[j])) {
      set.delete(str[i++]);
    } else {
      set.add(str[j]);
      j++;
      longest = Math.max(longest, j - i);
    }
  }
  return longest;
}

/* 
    optimization: using map, to store last shown index
    d b c a d e
            i
            j
    time: o(n)
    space: o(1) 
*/

function getLongest2(str) {
  let start = 0;
  let longest = 0;
  let map = new Map();

  for (let i = 0; i < str.length; i++) {
    if (map.has(str[i])) {
      if (map.get(str[i]) >= start) {
        start = map.get(str[i]) + 1;
      }
    }
    longest = Math.max(longest, i - start + 1);
    map.put(str[i], i);
  }
  return longest;
}
