function grapgh(edges) {
  let inDegree = {}; // num of indegrees
  let parent = {}; // dict of parents
  for (edge of edges) {
    if (inDegree[edge[0]] == null) {
      inDegree[edge[0]] = 0;
      parent[edge[0]] = [];
    }
    if (inDegree[edge[1]] == null) {
      inDegree[edge[0]] = 0;
      parent[edge[1]] = [];
    }
    inDegree[edge[1]]++;
    parent[edge[1]] = [...parent[edge[1]], edge[0]];
  }

  function hasCommon(a, b) {
    let parentA = new Set();
    getAll(parentA, a);
    let parentB = new Set();
    getAll(parentB, b);
    for (let el of parentA) {
      if (parentB.has(el)) return true;
    }
    return false;
  }

  function getAll(parents, item) {
    parents.add(item);
    if (parent[item] == null || !parent[item].length) return;
    let tmp = parent[item];
    for (el of tmp) {
      getAll(parents, el);
    }
  }
}
