// n: total number of
//
//
function allValidP(n) {
  let result = [];
  let builder = '';
  dfs(0, 0, builder);
  return result;

  function dfs(left, right, builder) {
    //base case
    if (left + right === n * 2) {
      result.push(builder.slice()); // push in copy of curr str builder
    }

    if (left < n) {
      builder += '(';
      allValidP(left + 1, right, builder);
      builder.slice(0, builder.length - 1);
    }

    if (right < left) {
      builder += ')';
      allValidP(left, right + 1, builder);
      builder.slice(0, builder.length - 1);
    }
  }
}
