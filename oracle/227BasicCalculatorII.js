/**
 * @param {string} s
 * @return {number}
 *
 * for operations we first do on curr sum.
 *
 *
 *
 */
var calculate = function(s) {
  //edge cases
  if (s == null || s.length == 0) {
    return null;
  }

  let totalSum = 0;
  let currSum = 0;
  let currNum = 0;
  let op = '+';
  // s.replace(' ', '');

  for (let i = 0; i < s.length; i++) {
    let c = s[i];
    // its number
    if (c >= '0' && c <= '9') {
      currNum = currNum * 10 + Number(c);
    }
    // if it's sign
    if (c == '+' || c == '-' || c == '*' || c == '/' || i === s.length - 1) {
      switch (op) {
        case '+':
          currSum += currNum;
          break;
        case '-':
          currSum -= currNum;
          break;
        case '*':
          currSum *= currNum;
          break;
        case '/':
          currSum /= currNum;
          break;
      }
      if (c == '+' || c == '-' || i === s.length - 1) {
        totalSum = Math.floor(totalSum + currSum);
        currSum = 0;
      }
      op = c;
      currNum = 0;
    }
  }
  return totalSum;
};

console.log(calculate('14/3*2'));
