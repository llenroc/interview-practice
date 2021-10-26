var isRobotBounded = function(instructions) {
  let posX = 0;
  let posY = 0;
  let currDir = 0;
  let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];

  function go(key) {
    switch (key) {
      case 'G':
        return function() {
          posX += dirs[currDir][0];
          posY += dirs[currDir][1];
        };
      case 'L':
        return function() {
          if (currDir === 0) {
            currDir = 3;
          } else {
            currDir--;
          }
        };
      case 'R':
        return function() {
          if (currDir === 3) {
            currDir = 0;
          } else {
            currDir++;
          }
        };
    }
  }

  for (let instruction of instructions) {
    go(instruction)();
  }
  return (posX === 0 && posY === 0) || currDir > 0;
};
