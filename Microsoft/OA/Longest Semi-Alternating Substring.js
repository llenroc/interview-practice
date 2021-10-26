/**
 * 给定一个长度为NN且只包含a和b的字符串SS。
 * 你需要找出最长的子串长度，使得其中不包含三个连续的字母。
 * 即，找出不包含aaa或bbb的最长子串长度。注意SS是其本身的子串
 * 
 * use two pointer, we just need to make sure char at index[right - 2, right] aren't the same,
 * if they are movethe pointer
 */

function getLongest(str) {
    if (str.length < 3) return 0;

    let max = 0;
    let dupCount = 1;

    for (let left = 0, right = 0; right < str.length; right++) {
        if (right > 0 && str[right] === str[right - 1]) {
            dupCount++
        } else {
            dupCount = 1; // reset count when the letter is different
        }

        if (dupCount === 3) {
            left = right - 1; // we start from the earlest point as possible, which only includes 2 of the same
            dupCount = 2;
        }

        max = Math.max(max, right - left + 1);
    }

    return max;
}