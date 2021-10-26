function getCount(str) {
    if (!str || !str.length) return 0;

    let removals = 0; // min number of removals
    let i = 0;

    while (i < str.length - 2) {
        if (str[i] === str[i + 1] && str[i] === str[i + 2]) {
            // we find 3 consecutive number, need to insert
            removals++;
            // we should insert at the last position of the three
            // to make sure we are using the minum insertion
            i = i + 2;
        } else {
            i++;
        }
    }

    return removals;
}