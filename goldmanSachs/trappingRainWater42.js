/**
 * @param {number[]} height
 * @return {number}
 *
 * two pointers: eyes on the tallest bar, and move the other pointer closer to it
 * we calculate tap water while we move poniters
 * Time O(n)
 * Space O(1)
 */
var trap = function(height) {
  let i = 0;
  let j = height.length - 1;
  let leftMax = 0;
  let rightMax = 0;
  let water = 0;

  while (i < j) {
    leftMax = Math.max(leftMax, height[i]);
    rightMax = Math.max(rightMax, height[j]);

    if (leftMax <= rightMax) {
      water += leftMax - height[i];
      i++;
    } else {
      water += rightMax - height[j];
      j--;
    }
  }
  return water;
};
