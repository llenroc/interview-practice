function differentTeams(skills) {
  // let res = 0;
  let res = Number.MAX_SAFE_INTEGER;
  let map = {
    p: 0,
    c: 0,
    m: 0,
    b: 0,
    z: 0
  };

  for (let i = 0; i < skills.length; i++) {
    let char = skills[i];
    if (map[char] != null) {
      map[char] += 1;
    }
  }
  Object.keys(map).forEach(key => {
    if (map[key] === 0) {
      return 0;
    } else {
      res = Math.min(res, map[key]);
    }
  });
  return res;
}
