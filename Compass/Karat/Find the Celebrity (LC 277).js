/**
 * Definition for knows()
 * 
 * @param {integer} person a
 * @param {integer} person b
 * @return {boolean} whether a knows b
 * knows = function(a, b) {
 *     ...
 * };
 */

/**
 * @param {function} knows()
 * @return {function}
 */
var solution = function (knows) {
    /**
     * @param {integer} n Total people
     * @return {integer} The celebrity
     */
    return function (n) {
        let candidate = 0;
        /**
         * if a knows b then a < b, if a does not know b, a > b. 
         * Then if there is a celebrity, he/she must be the "maximum" of the n people.
         */

        // The first loop is to exclude n - 1 labels that are not possible to be a celebrity.
        for (let i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // to verify x is actually a celebrity by definition.
        for (let i = 0; i < n; i++) {
            if ((i !== candidate && knows(candidate, i)) || !knows(i, candidate)) return -1;
        }
        return candidate;
    };
};