/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    let dict = new Set(wordList)
    let vis = new Set();
    let q = [];
    q.push(beginWord);
    let len = 1;
    while (q.length) { // 迭代 长度
        let level = q.length;
        for (let i = 0; i < level; i++) { //检查 当前 这一层（这个长度）neighbor
            let w = q.shift();
            if (w === endWord) return len;

            for (let j = 0; j < w.length; j++) {
                let ch = w.split('');    // 这个要放在里面 因为每次更新一个ch 所以要重新initialize一次 要不然 把之前的也储存了
                for (let i = 'a'.charCodeAt(); i <= 'z'.charCodeAt(); i++) {
                    let c = String.fromCharCode(i);
                    if (c === w[j]) continue;
                    ch[j] = c;
                    let nb = ch.join(''); // charArray  to String
                    if (dict.has(nb) && !vis.has(nb)) {
                        q.push(nb);
                        vis.add(nb);
                    }
                }
            }
        }
        len++;  // 增加长度
    }
    return 0;
};

let param1 = "hit";
let param2 = "cog";
let param3 = ["hot", "dot", "dog", "lot", "log", "cog"];
console.log(ladderLength(param1, param2, param3));