/**
 * Question 1
   返回最大的combination str.length不超过 max
 */

function solution(words, maxLength) {
    let left = 0;
    let result = [];
    while (left < words.length) {
        let right = findRight();
        // question 1 自己写
        // result.push(getWords(left, right));

        // question 2
        result.push(getJustifiedText(left, right));

        left = right + 1;
    }

    function findRight() {
        let right = left;
        let sum = words[right].length;
        right++;
        while (right < words.length && (sum + 1 + words[right].length) <= maxLength) {
            sum += 1 + words[right].length;
            right++;
        }
        return right - 1;
    }

    function getJustifiedText(left, right) {
        let numWords = right - left;
        if (numWords === 0) {
            if (right === words.length - 1) {
                return words[left];
            }
            return editWord(words[left]);
        }

        let totalWordsLen = 0;
        for (let i = left; i <= right; i++) {
            totalWordsLen += words[i].length;
        }
        let totalDash = maxLength - totalWordsLen;

        let dash = getDash(Math.floor(totalDash / numWords));
        let remainder = getDash(totalDash % numWords);

        let result = '';
        for (let i = left; i <= right; i++) {
            result += words[i] + dash;
            if (left = right - 1) {
                result += remainder;
            }
        }

        return result.trim();
    }

    function editWord(word) {
        let dashNum = maxLength - word.length;
        return result + getDash(dashNum);
    }

    function getDash(len) {
        let dash = '';
        for (let i = 0; i < dashNum; i++) dash += '-';
        return dash;
    }
}