/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDiagonalOrder = function (matrix) {
    // Check for empty matrices
    if (matrix == null || matrix.length == 0) {
        return [];
    }

    // Variables to track the size of the matrix
    let N = matrix.length;
    let M = matrix[0].length;


    let result = new Array(N * M);
    let k = 0;
    let intermediate = [];

    // We have to go over all the elements in the first
    // row and the last column to cover all possible diagonals
    for (let d = 0; d < N + M - 1; d++) {

        // Clear the intermediate array every time we start
        // to process another diagonal
        intermediate = [];

        // We need to figure out the "head" of this diagonal
        // The elements in the first row and the last column
        // are the respective heads.
        let r = d < M ? 0 : d - M + 1;
        let c = d < M ? d : M - 1;

        // Iterate until one of the indices goes out of scope
        // Take note of the index math to go down the diagonal
        while (r < N && c > -1) {

            intermediate.push(matrix[r][c]);
            ++r;
            --c;
        }

        // Reverse even numbered diagonals. The
        // article says we have to reverse odd 
        // numbered articles but here, the numbering
        // is starting from 0 :P
        if (d % 2 == 0) {
            intermediate.reverse();
        }

        for (let i = 0; i < intermediate.length; i++) {
            result[k++] = intermediate[i];
        }
    }
    return result;
};