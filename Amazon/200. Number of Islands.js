/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    if (!grid) return 0;

    let islands = 0;
    let row = grid.length;
    let col = grid[0].length;

    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (grid[i][j] === '1') {
                islands++;
                fillVisited(i, j);
            }
        }
    }

    return islands;

    function fillVisited(x, y) {
        if (x < 0 || y < 0 || x > row) return;

        if (grid[x][y] === '1') grid[x][y] = 'x';

        fillVisited(x + 1, y);
        fillVisited(x - 1, y);
        fillVisited(x, y + 1);
        fillVisited(x, y - 1);
    }
};