function calculator_1(str) {
    if (!str) return 0;

    let sign = 1;
    let res = 0;
    let digits = '';
    for (let i = 0; i < str.length; i++) {
        let ch = str[i];
        if (Number.isInteger(Number(ch))) {
            digits += ch;
        } else {
            if (digits) {
                res += sign * Number(digits);
                digits = '';
            }
            if (ch === '+') {
                sign = 1;
            } else if (ch === '-') {
                sign = -1;
            }
        }
    }
    if (digits) {
        res += sign * Number(digits);
    }
    return res;
}

function calculator_2(str) {
    if (!str) return 0;

    let sign = 1;
    let res = 0;
    let digits = '';
    let stack = [];
    for (let i = 0; i < str.length; i++) {
        let ch = str[i];
        if (Number.isInteger(Number(ch))) {
            digits += ch;
        } else {
            if (digits) {
                res += sign * Number(digits);
                digits = '';
            }
            if (ch === '+') {
                sign = 1;
            } else if (ch === '-') {
                sign = -1;
            } else if (ch === '(') {
                stack.push(res, sign);
                res = 0;
                sign = 1;
            } else if (ch === ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
    }
    if (digits) {
        res += sign * Number(digits);
    }
    return res;
}

function calculator_3(str, dict) {
    if (!str) return 0;

    let sign = 1;
    let res = 0;
    let digits = '';
    let stack = [];
    let alphas = [];
    for (let i = 0; i < str.length; i++) {
        let ch = str[i];
        if (ch.match(/^[a-z]+$/i) !== null) {
            if (dict[ch]) {
                res += sign * dict[ch];
            } else {
                if (sign === 1) {
                    alphas.push(`+${ch}`);
                } else {
                    alphas.push(`-${ch}`);
                }
            }
        }
        if (Number.isInteger(Number(ch))) {
            digits += ch;
        } else {
            if (digits) {
                res += sign * Number(digits);
                digits = '';
            }
            if (ch === '+') {
                sign = 1;
            } else if (ch === '-') {
                sign = -1;
            } else if (ch === '(') {
                stack.push(res, sign);
                res = 0;
                sign = 1;
            } else if (ch === ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
    }
    if (digits) {
        res += sign * Number(digits);
    }
    while (alphas.length != 0) {
        res += alphas.pop();
    }
    return res;
}

console.log(calculator_1("7+13-4")) // #16
console.log(calculator_2("-(1+2+3)+5")) // #-1
console.log(calculator_2("-(1-(2+3)+2)+5")) // #7
console.log(calculator_3("-(1-(2+3)+2)+a", { "a": 5 })) // #7
console.log(calculator_3("-(1-(a+3)+a)+5", { "a": 2 })) // #7
console.log(calculator_3("c-(1-(a+3)+a)-b", { "a": 2 })) // #7