/**
 * @param {number[][]} wall
 * @return {number}
 * for each number in a row, it's sum thus far =  position brick to the left boundary
 * we store the frequency, of each sum in a map. the most frequncy means the most num of bricks at given position brick
 * we update global max brick count. result = list.len - count(max) = min;
 **/

var leastBricks = function(wall) {
  if (!wall || wall.length === 0) return 0;

  let map = new Map();
  let maxCount = 0;
  for (let row of wall) {
    let sum = 0;
    for (let i = 0; i < row.length - 1; i++) {
      sum += row[i];
      let freq = map.get(sum) + 1 || 1;
      map.set(sum, freq);
      maxCount = Math.max(maxCount, freq);
    }
  }
  return wall.length - maxCount;
};
