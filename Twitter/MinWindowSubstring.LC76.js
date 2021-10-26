function getMin(str, target) {

    // construct a hashmap to store unique letter of target string
    let dict = new Map();
    for(let i = 0; i < target.length; i++) {
        let count = dict.has(target[i])? count + 1: 1;
        dict.set(target[i], count);
    }

    let count = dict.size();
    let start = 0;
    let end = 0;
    let minStart = 0;
    let minLen = Number.MAX_SAFE_INTEGER;

    while(end < str.length) {
        if(dict.has)
    }
}