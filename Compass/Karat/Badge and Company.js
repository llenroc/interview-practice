function find_mismatched_entries(records) {
    let map = new Map();

    for (let record of records) {
        if (record[1] === 'enter') {
            map.set(record[0], (map.get(record[0]) || 0) + 1);
        } else if (record[1] === 'exit') {
            map.set(record[0], (map.get(record[0]) || 0) - 1);
        }
    }

    // iterate map
    let enterNoExit = [];
    let exitNoEnter = [];
    for (let [key, val] of map) {
        if (val > 0) {
            enterNoExit.push(key);
        } else if (val < 0) {
            exitNoEnter.push(key);
        }
    }

    return [enterNoExit, exitNoEnter];
}

let badge_records = [
    ["Martha", "exit"],
    ["Paul", "enter"],
    ["Martha", "enter"],
    ["Martha", "exit"],
    ["Jennifer", "enter"],
    ["Paul", "enter"],
    ["Curtis", "enter"],
    ["Paul", "exit"],
    ["Martha", "enter"],
    ["Martha", "exit"],
    ["Jennifer", "exit"]
]

// console.log(find_mismatched_entries(badge_records));

function unusual_entries(records) {
    let map = new Map();
    let result = {};
    records.sort((a, b) => a[1] - b[1]);
    for (let record of records) {
        if (map.has(record[0])) {
            let list = map.get(record[0]);
            list.push(record[1]);
        } else {
            let list = [record[1]];
            map.set(record[0], list);
        }
    }
    for (let [key, val] of map) {
        let unusalEntries = getUnusaul(val);
        if (unusalEntries && unusalEntries.length >= 3) {
            result[key] = unusalEntries;
        }
    }
    return result;

    function getUnusaul(list) {
        if (!list || list.length < 3) return [];

        let result = [];
        for (let i = 2; i < list.length; i++) {
            if (list[i] - list[i - 2] <= 100) {
                if (result.length < 3) {
                    result = [...result, list[i - 2], list[i - 1], list[i]];
                } else {
                    result = [...result, list[i]];
                }
            }
        }

        return result;
    }
}

let badge_records_2 = [
    ["Paul", 1315],
    ["Jennifer", 1910],
    ["John", 830],
    ["Paul", 1355],
    ["John", 835],
    ["Paul", 1405],
    ["Paul", 1630],
    ["John", 855],
    ["John", 915],
    ["John", 930],
    ["Jennifer", 1335],
    ["Jennifer", 730],
    ["John", 1630],
];

console.log(unusual_entries(badge_records_2));