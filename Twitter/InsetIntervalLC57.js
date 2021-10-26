/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
*/
function insertInterval(intervals, newInterval) {
  //edge cases
  if (!intervals || !intervals.length) return [];

  let result = [];
  let overlap = newInterval;
  let i = 0;

  // Add insertion before list straight to the result
  while (i < intervals.length && intervals[i][1] < newInterval[0]) {
    result.push(intervals[i]);
    i++;
  }

  //traverse through the list
  while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
    // merge all overlapping intervals into a new interval
    overlap = [
      Math.min(intervals[i][0], newInterval[0]),
      Math.max(intervals[i][1], newInterval[1])
    ];
    i++;
  }
  result.push(overlap);

  // Add the remaining if any
  while (i < intervals.length) {
    result.push(intervals[i]);
    i++;
  }

  return result;
}

console.log(
  insertInterval([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8])
);
