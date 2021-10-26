/**
 * @param {number[][]} intervals
 * @return {boolean}
 */
var canAttendMeetings = function (intervals) {
    if (!intervals || !intervals.length) return true;
    intervals = intervals.sort((a, b) => a[0] - b[0]);

    for (let i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < intervals[i - 1][1]) {
            return false;
        }
    }
    return true;
};


/**
 * Meeting rooms II
 * 
 * why can we sort start and end sperately?
 * When we encounter an ending event, that means that some meeting that started earlier has ended now. 
 * We are not really concerned with which meeting has ended. All we need is that some meeting ended thus making a room available.
 * 
 * Time: O(NlogN) , Space: O(N)
 */

function fetRooms(intervals) {
    let startIntervals = [];
    let endIntervals = [];

    for (let interval of intervals) {
        startIntervals.push(interval[0]);
        endIntervals.push(interval[1]);
    }

    startIntervals.sort((a, b) => a - b);
    endIntervals.sort((a, b) => a - b);

    let usedRoom = 0;
    let startPointer = 0;
    let endPointer = 0;

    while (startPointer < startIntervals.length) {
        if (startIntervals[startPointer] >= endIntervals[endPointer]) {
            {
                endPointer++;
                usedRoom--;
            }
            usedRoom++;
            startPointer++;
        }
        return usedRoom;
    }