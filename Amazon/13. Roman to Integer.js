/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
  if (!s) return null;

  let map = new Map();
  let start = 0;
  let result = 0;

  map.set('I', 1);
  map.set('V', 5);
  map.set('X', 10);
  map.set('L', 50);
  map.set('C', 100);
  map.set('D', 500);
  map.set('M', 1000);
  map.set('IV', 4);
  map.set('IX', 9);
  map.set('XL', 40);
  map.set('XC', 90);
  map.set('CD', 400);
  map.set('CM', 900);

  while (start < s.length) {
    // check double digits
    if (start < s.length - 1) {
      let doubleDigits = s.substring(start, start + 2);
      if (map.has(doubleDigits)) {
        result += map.get(doubleDigits);
        start += 2;
        continue;
      }
    }

    //check single digits cases
    let singleDigits = s.substring(start, start + 1);
    if (map.has(singleDigits)) {
      result += map.get(singleDigits);
      start++;
    }
  }

  return result;
};
