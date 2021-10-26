/* 
isInteger() // judge the element if number
getInteger() // get number element
getList() // get not number element
*/

/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */

var NestedIterator = function(nestedList) {
  this.list = nestedList;
};

/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
  while (!this.list.length) {
    if (this.list[0].isInteger()) {
      return true;
    } else {
      let tmpList = this.list.shift().getList();
      this.list.unshift(...tmpList);
    }
  }
  return false;
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
  return this.list.shift().getInteger();
};

/**
 * Your NestedIterator will be called like this:
 * var i = new NestedIterator(nestedList), a = [];
 * while (i.hasNext()) a.push(i.next());
 */
