/**
 * @param {string} s
 * @return {string}
 * 
 * O (maxK * n) max K, n is len of given str
 * O (m + n) m: letter #, n: number #
 */
var decodeString = function (s) {
    let stringStack = [];
    let countStack = [];
    let k = 0;
    let currStr = '';

    for (let i = 0; i < s.length; i++) {
        if (s[i] >= '0' && s[i] <= '9') {
            k = k * 10 + Number(s[i]);
        } else if (s[i] === '[') {
            stringStack.push(currStr);
            countStack.push(k);

            k = 0;
            currStr = '';
        } else if (s[i] === ']') {
            let prevStr = stringStack.pop();
            let count = countStack.pop();

            for (let j = 0; j < count; j++) {
                prevStr += currStr;
            }

            currStr = prevStr;
        } else {
            currStr += s[i];
        }
    }

    return currStr;
};

/**
 * @param {string} s
 * @return {string}
 * 
 * O (max maxK ^ countK * n);
 * O(maxK[nmaxK[n]]) sum of all decoded string
 */
var decodeString = function (s) {
    let stack = [];

    for (let i = 0; i < s.length; i++) {
        if (s[i] === ']') {
            let curr = [];
            while (stack[stack.length - 1] !== '[') {
                curr.push(stack.pop());
            }

            stack.pop();
            let base = 1;
            let count = 0;
            while (stack.length && !isNaN(stack[stack.length - 1])) {
                count = count + Number(stack.pop()) * base;
                base *= 10;
            }

            while (k > 0) {
                for (let j = curr.length - 1; j >= 0; j--) {
                    stack.push(curr[j]);
                }
                k--;
            }
        } else {
            stack.push(s[i]);
        }
    }

    let len = stack.length;
    let result = new Array(len);
    for (let i = stack.length - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }

    return result.join();
};


