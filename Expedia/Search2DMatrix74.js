/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 *
 *
 * use binary search
 * left: 0, right: mn - 1
 * for each mid, => [mid / col] [mid % col]
 *
 * time: O(logn)
 * space: O(1)
 *
 */
var searchMatrix = function(matrix, target) {
  if (!matrix || !matrix.length) return false;

  let rows = matrix.length;
  let cols = matrix[0].length;
  let left = 0;
  let right = rows * cols - 1;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    let midPnt = matrix[Math.floor(mid / cols)][mid % cols];
    if (midPnt === target) {
      return true;
    } else if (midPnt > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return false;
};
