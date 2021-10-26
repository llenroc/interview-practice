/**
 * Initialize your data structure here.
 * use bucket to represent each timeslots.
 */
var HitCounter = function() {
  this.timesList = new Array(300).fill(0);
  this.countList = new Array(300).fill(0);
};

/**
 * O(1)
 * Record a hit.
 * @param timestamp - The current timestamp (in seconds granularity).
 * @param {number} timestamp
 * @return {void}
 */
HitCounter.prototype.hit = function(timestamp) {
  let index = timestamp % 300;
  if (this.timesList[index] === timestamp) {
    // increment count that happens the same second
    this.countList[index]++;
  } else {
    // clear and update the bucket
    this.countList[index] = 1;
    this.timesList[index] = timestamp;
  }
};

/**
 *
 * Return the number of hits in the past 5 minutes.
 * @param timestamp - The current timestamp (in seconds granularity).
 * @param {number} timestamp
 * @return {number}
 */
HitCounter.prototype.getHits = function(timestamp) {
  let count = 0;
  for (let i = 0; i < 300; i++) {
    if (timestamp - this.timesList[i] < 300) {
      count += this.countList[i];
    }
  }
  return count;
};

/**
 * Your HitCounter object will be instantiated and called as such:
 * var obj = new HitCounter()
 * obj.hit(timestamp)
 * var param_2 = obj.getHits(timestamp)
 */
