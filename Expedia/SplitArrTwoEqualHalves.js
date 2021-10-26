/*
    1 , 2 , 3 , 4 , 5 , 5

    time: O(n) <= O(2*n)
    space?: O(1)
*/

function equalHalf(nums) {
  let lSum = 0;
  let rSum = 0;

  for (let num of nums) {
    lSum += num;
  }

  for (let i = nums.length - 1; i >= 0; i--) {
    rSum += nums[i];
    lSum -= nums[i];
    if (lSum === rSum) return i - 1;
  }
  return -1;
}

const nums = [1, 2, 3, 4, 5, 5];
console.log(equalHalf(nums));
