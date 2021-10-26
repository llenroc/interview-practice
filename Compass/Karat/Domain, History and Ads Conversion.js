var subdomainVisits = function (cpdomains) {
  let obj = {};
  let response = [];
  for (let str of cpdomains) {
    let temp = str.split(' ');
    let num = parseInt(temp[0]);
    let domain = temp[1].split('.');
    let key = domain.pop();
    obj[key] = obj[key] ? obj[key] + num : num;

    while (domain.length > 0) {
      key = domain.pop() + '.' + key;
      obj[key] = obj[key] ? obj[key] + num : num;
    }
  }

  for (let i in obj) {
    response.push(obj[i] + ' ' + i);
  }

  return response;
};

function findContiguousHistory(a, b) {
  let m = a.length;
  let n = b.length;

  let dp = new Array(m + 1);
  for (var i = 0; i < dp.length; i++) {
    dp[i] = new Array(n + 1).fill(0);
  }

  let max = [];
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (a[i - 1] === b[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
        if (dp[i][j] > max.length) {
          max = a.slice(i - dp[i][j], i);
        }
      }
    }
  }

  return max;
}

/**
 * Q3. 3 inputs: a list of user ids + IPs, a list of user ids who have made purchases, a list of advertisement
clicks with user IPs.
Each user id has at most 1 IP.
Output: for each ad, output the number of clicks and the number of purchases.
解法：过⼀遍ids + IPs 的list 建⼀个hashtable （ip->id), 过⼀遍ads计算clicks和purchases.
 */

let user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"];
let user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"];
let user2 = ["a", "/one", "/two"];
let user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"];
let user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"];
let user5 = ["a"];
let user6 = ["/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"];


// findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"];
// findContiguousHistory(user0, user2) => [] (empty)
// findContiguousHistory(user2, user1) => ["a"] 
// findContiguousHistory(user5, user2) => ["a"]
// findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
// findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
// findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

console.log(findContiguousHistory(user0, user1));
console.log(findContiguousHistory(user0, user2));
console.log(findContiguousHistory(user2, user1));
console.log(findContiguousHistory(user5, user2));
console.log(findContiguousHistory(user3, user4));
console.log(findContiguousHistory(user4, user3));
console.log(findContiguousHistory(user3, user6));
