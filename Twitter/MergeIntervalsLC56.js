function mergeIntervals(intervals) {
  if (!intervals || !intervals.length) return [];
  intervals.sort((a, b) => a[0] - b[0]);

  let result = [];
  result.push(intervals.shift());
  let prev = result[0];

  for (let interval of intervals) {
    if (interval[0] <= prev[1]) {
      prev[1] = Math.max(interval[1], prev[1]);
    } else {
      prev = interval;
      result.push(interval);
    }
  }

  return result;
}
