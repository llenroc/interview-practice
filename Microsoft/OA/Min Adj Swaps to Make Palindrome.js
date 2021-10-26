/**
 * 
 * @param {*} str 
" 1. Take two-pointer where the first pointer track from the left side of a string and second pointer keep track from the right side of a string.
  2.Till the time we find the same character, keep moving the right pointer to one step left.
  3. If the same character not found then return -1.
  4. If the same character found then swap the right pointer’s character towards right until it is not placed at it’s correct position in a string.
  5. Increase left pointer and repeat step 2. "
   - https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
 */

function count(str) {
    if (!str || !str.length) return 0;

    let swaps = 0;
    // in order to swap char within a string, we first convert it into array
    let strArray = str.split('');

    for (let i = 0; i < strArray.length / 2; i++) {
        let start = i;
        let end = strArray.length - start - 1;

        while (start < end) {
            if (strArray[start] === strArray[end]) {
                break;
            } else {
                end--;
            }
        }

        // we don't have enough chars to make the palindrom 
        // which requires at least 2 of the same letter
        if (left === right) {
            return -1;
        } else {
            for (let j = end; j < strArray.length - start - 1; j++) {
                let tmp = strArray[j];
                strArray[j] = strArray[j + 1];
                strArray[j + 1] = tmp
                swaps++;
            }
        }
    }

    return swaps;
}