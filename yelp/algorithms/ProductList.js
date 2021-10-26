/*
 *input是list of product，每个product有不同的attributes。要做的就是写一个function，找到某个attribute最大的数字，把它对应的product的dict返回出来。
 *product是一个dictionary ，比如{产品编号：1, 位置: xxxx, 价格：xxx}。
 *一共有三个function要写，但是都是基于这个的变形。
 *
 */

class Product {
  constructor(id, name, price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}

function findMaxPrice(prodList) {
  let maxPrice = Number.MIN_SAFE_INTEGER;
  let result;

  for (let prod of prodList) {
    if (prod.price > maxPrice) {
      maxPrice = prod.price;
      result = prod;
    }
  }
  return result;
}
