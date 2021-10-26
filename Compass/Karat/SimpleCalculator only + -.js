function calc(s) {
  let result = 0;
  let sign = 1;
  let stack = [];
  let opStack = [];

  for (let i = 0; i < s.length; i++) {
    const curr = s.charAt(i);

    if (curr === ' ') {
      continue;
    } else if (curr === '+') {
      sign = 1;
    } else if (curr === '-') {
      sign = -1;
    } else if (curr >= '0' && curr <= '9') {
      let val = curr;
      while (s[i + 1] >= '0' && s[i + 1] <= '9' && i < s.length - 1) {
        val += s[s + 1];
      }
      result += sign * Number(val);
    } else if (curr === '(') {
      stack.push(result);
      result = 0;
      opStack.push(sign);
      sign = 1;
    } else if (curr === ')') {
      result = opStack.pop() * result + stack.pop();
      sign = 1;
    }
  }
  return result;
}

function calculator3(str) {

}
