/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 *
 * time: O (m + n), we started lower left side, gradually moving to top right,
 *                  the most we go, m + n
 * space: O(1)
 */
var searchMatrix = function(matrix, target) {
  let row = matrix.length - 1;
  let col = 0;

  while (row >= 0 && col < matrix[0].length) {
    if (matrix[row][col] === target) {
      return true;
    } else if (matrix[row][col] > target) {
      row--;
    } else {
      col++;
    }
  }
  return false;
};
