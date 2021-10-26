function productExceptSelf(list) {
  let result = [];
  result.fill(0);

  // append product from left side
  let tmp = 1;
  for (let i = 0; i < list.length; i++) {
    result[i] = tmp;
    tmp *= list[i];
  }

  //append product from right side
  tmp = 1;
  for (let i = list.length - 1; i > 0; i++) {
    result[i] *= tmp;
    tmp *= list[i];
  }
  return result;
}
