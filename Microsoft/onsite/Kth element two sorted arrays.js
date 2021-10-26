// https://www.baeldung.com/java-kth-smallest-element-in-sorted-arrays
var getKElement = (list1, list2, k) => {
    // we are looking for the minimum value
    if (k == 1) return Math.min(list1[0], list2[0]);
    // we are looking for the maximum value
    if (list1.length + list2.length == k) return max(list1[list1.length - 1], list2[list2.length - 1]);
    // swap lists if needed to make sure we take at least one element from list1
    if (k <= list2.length && list2[k - 1] < list1[0]) {
        let tmp = list1;
        list1 = list2;
        list2 = tmp;
    }
    // correct left boundary if k is bigger than the size of list2
    let left = k < list2.length ? 0 : k - list2.length - 1;
    // the inital right boundary cannot exceed the list1 
    let right = Math.min(k - 1, list1.length - 1);
    let nElementsList1, nElementsList2;
    // binary search 
    do {
        nElementsList1 = Math.floor((left + right) / 2) + 1;
        nElementsList2 = k - nElementsList1;
        if (nElementsList2 > 0) {
            if (list1[nElementsList1 - 1] > list2[nElementsList2 - 1]) {
                right = nElementsList1 - 2;
            } else {
                left = nElementsList1;
            }
        }
    } while (!kthSmallesElementFound(list1, list2, nElementsList1, nElementsList2));

    return nElementsList2 == 0 ? list1[nElementsList1 - 1] : max(list1[nElementsList1 - 1], list2[nElementsList2 - 1]);
}

var kthSmallesElementFound = (list1, list2, nElementsList1, nElementsList2) => {
    // we do not take any element from the second list
    if (nElementsList2 < 1) return true;
    if (list1[nElementsList1 - 1] == list2[nElementsList2 - 1]) return true;
    if (nElementsList1 == list1.length) return list1[nElementsList1 - 1] <= list2[nElementsList2];
    if (nElementsList2 == list2.length) return list2[nElementsList2 - 1] <= list1[nElementsList1];
    return list1[nElementsList1 - 1] <= list2[nElementsList2] && list2[nElementsList2 - 1] <= list1[nElementsList1];
}