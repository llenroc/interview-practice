/*
       ["a","3", "a", "b", "b", "b", "c","c","c"]
                  i
                       j

         curr: 3
*/
var compress1 = function(chars) {
  let i = 0; // anhor such that [0, i] are compression
  let j = 0; // exploring and traversing thru list

  while (j < chars.length) {
    let currChar = chars[j];
    let count = 0;

    while (j < chars.length && chars[j] === currChar) {
      j++;
      count++;
    }
    chars[i++] = currChar;
    if (count > 1) {
      let freq = count.toString().split('');
      for (let num of freq) {
        chars[i++] = num;
      }
    }
    return i;
  }
};

var compress = function(chars) {
  if (!chars || !chars.length) return 0;
  let pointer = 0;

  for (let i = 0; i < chars.length; ) {
    let j = i + 1;

    while (j < chars.length && chars[i] === chars[j]) {
      j++;
    }
    if (j - i > 1) {
      let freq = j - i + '';
      for (let digit of freq.split('')) {
        chars[++pointer] = digit;
      }
    }
    pointer++;
    i = j;
  }
  return pointer;
};

const test = ['a', 'a', 'a', 'b', 'b', 'c', 'c', 'c'];
console.log(compress1(test));
