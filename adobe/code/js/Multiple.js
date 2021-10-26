function multiply(...arg) {
  function mul(...arg2) {
    return multiply(...arg, ...arg2);
  }
  let total = arg.reduce((total, val) => total * val);
  mul.value = total;
  return mul;
}
