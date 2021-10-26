function addStrings1(num1, num2) {
  let i = num1.length - 1;
  let j = num2.length - 1;
  let sum = '';
  let carry = 0;

  while (i >= 0 || j >= 0 || carry > 0) {
    let n1 = i < 0 ? 0 : num1.charAt(i) - '0';
    let n2 = j < 0 ? 0 : num2.charAt(j) - '0';
    let currSum = n1 + n2 + carry;
    sum = `${currSum % 10}` + sum;
    carry = Math.floor(currSum / 10);
    i--;
    j--;
  }

  return sum;
}

/**
 *
 * @param {*} num1
 * @param {*} num2
 *  split string numer to integer and float part, and calculate seperately
 *  first calculate float part, then integer. for float part, we need to append '0' if not equal len;
 *  time: (M + N);
 *  space: O(1)
 */

function addStrings2(num1, num2) {
  // edge cases, skip. assume all input are valid
  let [num1Int, num1Float] = num1.split('.');
  let [num2Int, num2Float] = num2.split('.');
  let floatResult = '';
  let intResult = '';

  // calculate float part
  let fCarry = 0;
  let fLen = num1Float.length;
  if (num1Float.length !== num2Float.length) makeEqualSize();
  let i = num1Float.length - 1;
  let j = num2Float.length - 1;
  while (floatResult.length <= fLen && (i >= 0 || j >= 0)) {
    let n1 = num1Float[i] - '0';
    let n2 = num2Float[j] - '0';
    let sum = n1 + n2;
    fCarry = Math.floor(sum / 10);
    floatResult = `${sum % 10}` + floatResult;
    i--;
    j--;
  }

  //calculate int part
  let intCarry = fCarry;
  let m = num1Int.length - 1;
  let n = num2Int.length - 1;
  while (m >= 0 || n >= 0 || intCarry > 0) {
    let n1 = num1Int[m] ? num1Int[m] - '0' : 0;
    let n2 = num2Int[n] ? num2Int[n] - '0' : 0;
    let sum = n1 + n2;
    intCarry = Math.floor(sum / 10);
    intResult = `${sum % 10}` + intResult;
    m--;
    n--;
  }

  return intResult + '.' + floatResult;

  function makeEqualSize() {
    fLen = Math.max(num1Float.length, num2Float.length);
    let diff = Math.abs(num1Float.length - num2Float.length);
    if (num1Float.length < num2Float.length) {
      for (let i = 0; i < diff; i++) num1Float += '0';
    } else {
      for (let i = 0; i < diff; i++) num2Float += '0';
    }
  }
}
// 10.9
// 12.23
let num1 = '10.005';
let num2 = '122.15';
console.log(addStrings2(num1, num2));
