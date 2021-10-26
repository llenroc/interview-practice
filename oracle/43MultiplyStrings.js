/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 * step 1: compute product from each pair
 * step 2: carry each sum carry over
 * step 3: convert output
 */
var multiply = function(num1, num2) {
  let result = '';
  let list = new Array(num1.length + num2.length + 1).fill(0);

  for (let i = num1.length - 1; i >= 0; i--) {
    for (let j = num2.length - 1; j >= 0; j--) {
      let n1 = num1[i] - '0';
      let n2 = num2[j] - '0';
      list[i + j + 1] += n1 * n2;
    }
  }

  let carry = 0;
  for (let i = list.length - 1; i >= 0; i--) {
    let tail = (list[i] + carry) % 10;
    carry = Math.floor((list[i] + carry) / 10);
    list[i] = tail;
  }
  for (let i = 0; i < list.length; i++) {
    result += list[i];
  }
  while (result.length != 0 && result[0] == '0') {
    result = result.substring(1);
  }
  return result == '' ? '0' : result;
};
