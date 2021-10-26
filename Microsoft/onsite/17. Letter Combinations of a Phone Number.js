var letterCombinations = function (digits) {
    if (!digits || !digits.length) return [];
    let result = [''];
    let map = ["0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];

    for (let i = 0; i < digits.length; i++) {
        let index = Number(digits[i]);
        let str = map[index];
        while (result[0].length === i) {
            let curr = result.shift();
            for (let j = 0; j < str.length; j++) {
                result.push(curr + str[j]);
            }
        }
    }
    return result;
};