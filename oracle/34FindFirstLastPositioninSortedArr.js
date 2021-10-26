/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 
 * find left
 * 1, If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
   2, If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
   3, If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
 * 2 + 3 -> If A[mid] >= target, j = mid
 * 
 * find right
 * 1, If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
   2, If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
   3, If A[mid] = target, then the range must begins on the right of or at mid (i= mid)
 *  2 + 3 => 2* If A[mid] <= target, then i = mid;
 * 
 */
function searchRange(nums, target) {
  let res = [-1, -1];

  // find the left
  let l = 0;
  let r = nums.length - 1;

  while (l < r) {
    const mid = Math.floor((l + r) / 2); // note using Math.floor

    if (nums[mid] < target) l = mid + 1;
    else r = mid;
  }

  if (nums[l] !== target) return res;
  else res[0] = l;

  // find the right
  r = nums.length - 1; // no need to set l to 0

  while (l < r) {
    const mid = Math.ceil((l + r) / 2); // note using Math.ceil

    if (nums[mid] > target) r = mid - 1;
    else l = mid;
  }

  res[1] = r;

  return res;
}
