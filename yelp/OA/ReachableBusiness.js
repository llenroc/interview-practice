//  reachea‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‌ble business
// Note: call function need to insert businessName as the class Business itself instead of just the character of the business name
// set Graph
class Business {
  constructor(bName) {
    this.name = bName;
    this.nearbyBusinesses = new Set();
  }
  addNB(NB, dis) {
    var nearbyB = {};
    nearbyB['business'] = NB;
    nearbyB['distance'] = dis;
    this.nearbyBusinesses.add(nearbyB);
  }
}
var a = new Business('A');
var b = new Business('B');
var c = new Business('C');
var d = new Business('D');
b.addNB(d, 5);
a.addNB(b, 2);
a.addNB(c, 4);
// console.log(a.nearbyBusinesses) 把这行uncomment 就会出现 标记:爱心 那样的output了
// start of SOLUTION
function reacheableBusiness(businessName, targetDistance) {
  var dis = new Map();
  var res = [];
  bfs(businessName);
  for ([key, value] of dis) {
    if (value <= targetDistance) {
      res.push(key);
    }
  }
  function bfs(businessName, prevDistance = 0) {
    if (businessName.nearbyBusinesses) {
      businessName.nearbyBusinesses.forEach(function(elements) {
        dis.set(elements.business.name, elements.distance + prevDistance);
        if (elements.business.nearbyBusinesses) {
          bfs(elements.business, elements.distance);
        }
      });
    }
    return;
  }
  return res;
}
console.log(reacheableBusiness(a, 6));
// console.log(dis)
