const userHour = [7, 11];
const bussHour = [[9, 17]];

function getRatio(userHour, bussHourList) {
  //edge case
  if (!bussHourList || !bussHourList.length) return 0;
  const userStart = userHour[0];
  const userEnd = userHour[1];
  const userDuration = userHour[1] - userHour[0];
  let openHours = 0;

  for (let bussHour of bussHourList) {
    let overLap = getOverlap(bussHour[0], bussHour[1]);
    openHours += overLap;
  }

  return openHours / userDuration;

  function getOverlap(start, end) {
    let overLap = 0;
    let max = Math.max(userStart, start);
    let min = Math.min(userEnd, end);
    if (max < min) overLap = min - max;
    return overLap;
  }
}

console.log(getRatio(userHour, bussHour));
