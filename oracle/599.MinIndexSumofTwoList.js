/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function(list1, list2) {
  //making sure that list1 has smaller size
  if (list2.length < list1.length) return findRestaurant(list2, list1);
  let result = [];
  let min = Number.MAX_SAFE_INTEGER;
  //build map on list1, (interest, index)
  let map = new Map();
  for (let i = 0; i < list1.length; i++) {
    map.set(list1[i], i);
  }

  //traverse list 2, compare sum with gloval min
  for (let i = 0; i < list2.length; i++) {
    if (map.has(list2[i])) {
      let sum = i + map.get(list2[i]);
      if (sum < min) {
        result.length = 0;
        result.push(list2[i]);
        min = sum;
      } else if (sum === min) {
        result.push(list2[i]);
      }
    }
  }
  return result;
};
