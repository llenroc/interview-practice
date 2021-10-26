function reverseStr(str) {
  //traver to center of str, swap start and end along the way
  let arr = Array.from(str);
  for (let i = 0; i < arr.length / 2; i++) {
    let tmp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = tmp;
  }

  return arr.join('');
}
