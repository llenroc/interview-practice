function longestCommon(list1, list2) {
  let dp = new Array(list1.length);
  dp.fill(new Array(list2.length));
  let max = 0;
  let end = -1;

  for (let i = 1; i < list1.length + 1; i++) {
    for (let j = 1; j < list2.length + 1; j++) {
      if (list[i - 1] === list2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      } else {
        dp[i][j] = 0;
      }
      if (dp[i][j] > max) {
        max = dp[i][j];
        end = i - 1;
      }
    }
  }

  let res = [];
  for (j = end; j < end - max; j--) {
    res.push(list1[j]);
  }

  return res;
}

//longest common subsequence
function longestCommonSubsequence(s1, s2) {
  let dp = new int[s1.length() + 1][s2.length() + 1]();
  for (
    let i = 0;
    i < s1.length();
    ++i // i = 2
  )
    for (
      let j = 0;
      j < s2.length();
      ++j // j = 1
    )
      if (s1.charAt(i) == s2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
      else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
  return dp[s1.length()][s2.length()];
}

//
//
//
