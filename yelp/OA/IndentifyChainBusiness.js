// dataset:
// 1: A list of business containing only popular chains. Business names format: CHAIN_NAME - LOCATION - BUSINESS_ID
//    may contain dups
// 2: particular location.
// Task: output chain names along with num of unique business of the chain in a particular location, in DESC order
class Business {
  constructor(name, location, id) {
    this.name = name;
    this.location = location;
    this.id = id;
  }
}
class Chain {
  constructor(name, freq) {
    this.name = name;
    this.freq = freq;
  }
}

const list = [];
list.push(new Business('Walmart', 'San Jose', 1));
list.push(new Business('Bestbuy', 'San Jose', 3));

list.push(new Business('Walmart', 'Los Angeles', 1));
list.push(new Business('Walmart', 'Los Angeles', 2));
list.push(new Business('Walmart', 'Los Angeles', 3));
list.push(new Business('BestBuy', 'Los Angeles', 1));
list.push(new Business('BestBuy', 'Los Angeles', 2));
list.push(new Business('Apple', 'Los Angeles', 1));
list.push(new Business('Apple', 'Los Angeles', 2));

function chainBusiness(list, location) {
  //create map
  let result = [];
  let map = new Map(); // stores in particular location

  //create map for the particular location
  for (let business of list) {
    if (business.location === location) {
      let idSet = map.has(business.name) ? map.get(business.name) : new Set();
      idSet.add(business.id);
      map.set(business.name, idSet);
    }
  }

  map.forEach((value, key) => {
    result.push(new Chain(key, value.size));
  });

  result.sort((a, b) => {
    if (a.freq > b.freq) return -1;
    if (a.freq < b.freq) return 1;
    if (a.name.toLowerCase() > b.name.toLowerCase()) return 1;
    if (a.name.toLowerCase() < b.name.toLowerCase()) return -1;
    return 0;
  });

  return result;
}

console.log(chainBusiness(list, 'Los Angeles'));
