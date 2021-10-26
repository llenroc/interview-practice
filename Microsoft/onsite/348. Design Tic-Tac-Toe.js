var TicTacToe = function (n) {
    this.rows = new Array(n).fill(0);
    this.cols = new Array(n).fill(0);
    this.diag = 0;
    this.antiDiag = 0;
};

TicTacToe.prototype.move = function (row, col, player) {
    let move = player === 1 ? 1 : -1;
    let size = this.rows.length;

    if (row === col) this.diag += move;
    if ((size - row - 1) === col) this.antiDiag += move;
    this.rows[row] += move;
    this.cols[col] += move;

    if (
        Math.abs(this.rows[row]) === size
        || Math.abs(this.cols[col]) === size
        || Math.abs(this.diag) === size
        || Math.abs(this.antiDiag) === size
    ) {
        return player;
    }
    return 0;
};