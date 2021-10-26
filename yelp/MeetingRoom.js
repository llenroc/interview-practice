/*
* meeting room 1, 2. 都用了扫描线做的
* follow up 然后问如果想把不重叠的interval分别写出来怎么办，就用个pq，按end time排
*

    When we encounter an ending event, that means that some meeting that started earlier 
    has ended now. We are not really concerned with which meeting has ended. 
    All we need is that some meeting ended thus making a room available.
*/

function meetingRoom2(intervals) {
  if (!intervals || !intervals.length) return 0;

  let startList = [];
  let endList = [];
  let startPnt = 0;
  let endPnt = 0;
  let totalRooms = 0;

  //construct start, end list
  for (let interval of interval) {
    startList.push(interval[0]);
    endList.push(interval[1]);
  }

  // sort two lists accending
  startList.sort((a, b) => a - b);
  endList.sort((a, b) => a - b);

  while (startPnt < intervals.length) {
    if (startList[startPnt] < endList[endPnt]) {
      totalRooms++;
      startPnt++;
    } else {
      startPnt++;
      endPnt++;
    }
  }
  return totalRooms;
}
