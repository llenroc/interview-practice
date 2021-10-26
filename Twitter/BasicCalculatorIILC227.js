function calculate(s) {
  let res = 0,
    curRes = 0,
    num = 0,
    n = s.length;
  let op = '+';
  for (let i = 0; i < n; ++i) {
    let c = s[i];
    if (c >= '0' && c <= '9') {
      num = num * 10 + c - '0';
    }
    if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
      switch (op) {
        case '+':
          curRes += num;
          break;
        case '-':
          curRes -= num;
          break;
        case '*':
          curRes *= num;
          break;
        case '/':
          curRes /= num;
          break;
      }
      if (c == '+' || c == '-' || i == n - 1) {
        res += curRes;
        curRes = 0;
      }
      op = c;
      num = 0;
    }
  }
  return res;
}
