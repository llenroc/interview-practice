const data1 = [
  ['JFK', 'SFO'],
  ['SFO', 'EWR'],
  ['EWR', 'SEA'],
  ['SEA', 'ABC'],
  ['ABC', 'EFG'],
  ['EFG', 'JFK']
];

const data2 = [
  ['JFK', 'SFO'],
  ['SFO', 'EWR'],
  ['SFO', 'SEA'],
  ['SEA', 'ABC'],
  ['JFK', 'EFG']
];

//no circle, no multi degree
function getDestination1(data, target) {
  //edge cases
  if (!data || !data.length) return null;

  let map = buildMap(data);
  let visited = new Set();
  let path = [];
  visited.add(target); // to deal with circle cases
  path.push(target);

  dfs(target);
  console.log(path);
  return path[path.length - 1];

  function buildMap(data) {
    let map = new Map();
    for (let dest of data) {
      let [start, end] = dest;
      if (!map.has(start)) map.set(start, end);
    }
    return map;
  }

  function dfs(target) {
    if (!map.has(target)) return;
    let val = map.get(target);
    if (visited.has(val)) {
      path.push('loop');
      return;
    }

    path.push(val);
    visited.add(val);
    dfs(val);
  }
}
function getDestination2(data, target) {
  //edge cases
  if (!data || !data.length) return [];

  // build a map with (place, number of places it goes next)
  let map = new Map();
  // for (let trip of data) {
  //   let [dep, dest] = trip;
  //   if (!map.has(dep)) map.set(dep, []);
  //   if (!map.has(dest)) map.set(dest, []);
  // }

  for (let trip of data) {
    let [dep, dest] = trip;
    let destList = map.get(dep) || [];
    destList.push(dest);
    map.set(dep, destList);
  }

  let result = [];
  let queue = [];
  queue.push(target);

  while (queue.length) {
    let curr = queue.shift();
    let neighbors = map.get(curr);
    if (!neighbors) {
      result.push(curr);
      continue;
    }
    for (let neighbor of neighbors) queue.push(neighbor);
  }

  return result;
}

// with possible circle
console.log('getDestination 1', getDestination1(data1, 'JFK'));
// console.log(getDestination2(data2, 'JFK'));
