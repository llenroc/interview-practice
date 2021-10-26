/**
 * @param {string} s
 * @return {string}
 */
var shortestPalindrome = function (s) {
    let toAdd = '';
    let testStr = s;

    while (testStr.length > 0) {
        if (isPalindrome(testStr)) break;
        toAdd += testStr[testStr.length - 1];
        testStr = testStr.substring(0, testStr.length - 1);
    }

    return toAdd + s;
};

var isPalindrome = (str) => {
    if (str.length === 1) return true;
    for (let i = 0, j = str.length - 1; i < j; i++, j--) {
        if (str[i] !== str[j]) return false;
    }
    return true;
}