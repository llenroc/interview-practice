
/**
 * 
 * @param {string} day 
 * @param {number} k 
 */
function getDay(day, k) {
    let days = ["Sun", "Mon", "Tue", "Wed",
        "Thu", "Fri", "Sat"];

    let weekMap = {
        "Sun": 0,
        "Mon": 1,
        "Tue": 2,
        "Wed": 3,
        "Thu": 4,
        "Fri": 5,
        "Sat": 6
    }

    let dayNumber = weekMap[day];
    let dayAfterK = (dayNumber + K) % 7;
    return days[dayAfterK];
}