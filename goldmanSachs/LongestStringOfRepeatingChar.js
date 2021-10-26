/*
    a b b b c c c c d a
            i
                  j
*/

function getMax(str) {
  let max = 0; //  3
  let start = 0; // 1
  let i = 0;
  let j = 0;

  while (j < str.length) {
    if (str[i] !== str[j]) {
      i = j;
    } else {
      j++;
      if (j - i > max) {
        start = i; //
        max = j - i; //
      }
    }
  }

  return [start, max];
}

const test = 'abbbcccda';
console.log(getMax(test));
