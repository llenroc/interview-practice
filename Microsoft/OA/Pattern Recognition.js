
function testMatch(pat, str) {
    if (pat.length === 0 || str.length === 0) return 0;

    let count = 0;
    for (let i = 0; i <= str.length - pat.length; i++) {

        let j = 0;
        for (j = 0; j < pat.length; j++) {
            if (pat[j] !== str[i + j]) break;
        }
        if (j == pat.length) count++;
    }
    return count;
}

/**
 * 
 * @param {*} input 
 * Time: O(m*n)
 * Space: O(1)
 */
function patternMatch(input) {
    if (!input || !input.length) return null;

    let patternList = input.split(';');
    let pattern = patternList[0];
    let list = patternList[1].split('|');

    let total = 0;
    let result = '';
    for (let ele of list) {
        let count = testMatch(pattern, ele);
        total += count;
        // result = result.concat(count + '|');
        result = `${result}${count}|`;
    }
    return result + total;
}

// 0|0|0|0|0
let input1 = ';bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|lbcdef23423bc32';
// 4|2|3|2|11
let input2 = 'b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|lbcdef23423bc32';
// 4|4|2|0|10
let input3 = 'aa;aaaakjlhaa|aaadsaaa|easaaad|sa';
// 3|2|1|2|8
let input4 = 'bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|lbcdef23423bc32';


console.log(patternMatch(input1));
console.log(patternMatch(input2));
console.log(patternMatch(input3));
console.log(patternMatch(input4));


