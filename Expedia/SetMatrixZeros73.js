/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */

/*
using 2 sets, to mark row, col that contain 0s.
time: O(M * N), we go thru every cell in the matrix
space: O(M + N);
*/
var setZeroes = function(matrix) {
  let rowSet = new Set();
  let colSet = new Set();

  //traverse matrix and sets, mark row,col for each 0 position
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (matrix[i][j] === 0) {
        rowSet.add(i);
        colSet.add(j);
      }
    }
  }

  //traverse matrix, for each cell, if row/col marked already, set 0
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (rowSet.has(i) || colSet.has(j)) {
        matrix[i][j] = 0;
      }
    }
  }
};
