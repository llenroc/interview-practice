/**
 * @param {number[]} height
 * @return {number}
 * O(n)
 * O(1)
 */
var maxArea = function (height) {
  if (!height) return 0;

  let max = 0;
  let left = 0;
  let right = height.length - 1;

  while (left < right) {
    let water = Math.min(height[left], height[right]) * (right - left);
    max = Math.max(max, water);

    if (height[left] > height[right]) {
      right--;
    } else {
      left++;
    }
  }

  return max;
};
