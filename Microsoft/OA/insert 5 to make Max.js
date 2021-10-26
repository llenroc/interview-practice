/**
 *  You can place the number "5" anywhere in the number to make it the largest number.
So like if you have "9991" you place "5" here: "99951", also handle negative numbers too too.
 */

// insert 5 to the front if positive num
// insert 5 to the end if neg

/**
 * https://share.jiuzhang.com/solution?id=120283
 */

// 无论正负数，都是从左往右遍历，正数的话，碰到>=5的往右走，负数的话，碰到<=5的往右走
function getMax(num) {
    let str = Math.abs(num).toString();
    let isPositive = num >= 0;
    let index = 0;

    if (isPositive) {
        while (index < str.length() && (str[index] >= '5')) {
            index++;
        }
        str.splice(index, 0, '5');
    } else {
        while (index < str.length && (str[index] < '5')) {
            index++;
        }
        str.splice(index, 0, '5');
    }
    return str;
}