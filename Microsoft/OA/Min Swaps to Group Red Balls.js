/**
 * https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-swaps-to-group-red-balls-aedd07dc5cd2
 * 
 */

function getMin(str) {
    let countRed = 0;

    for (let i = 0; i < str.length; i++) {
        if (str[i] === 'R') countRed++;
    }

    let start = 0;
    let end = str.length - 1;
    let min = 0;

    while (start < end) {
        if (str[start] === 'R' && str[end] === 'R') {
            // when we see red pair
            // we add to the result number of Ws between these two R
            countRed -= 2;
            min += end - start - 1 - countRed;

            //closing off the window
            start++;
            end--;
        } else if (str[start] != 'R') {
            start++;
        } else {
            end--;
        }
    }

    return min;
}