/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
  let letters = [
    'M',
    'CM',
    'D',
    'CD',
    'C',
    'XC',
    'L',
    'XL',
    'X',
    'IX',
    'V',
    'IV',
    'I',
  ];
  let numbers = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  let result = '';

  for (let i = 0; i < letters.length && num >= 0; i++) {
    if (numbers[i] <= num) {
      while (numbers[i] <= num) {
        result += letters[i];
        num -= numbers[i];
      }
    }
  }

  return result;
};
