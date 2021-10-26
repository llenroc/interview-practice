/**
 * Alexa is given n piles of equal or unequal heights. 
 * In one step, Alexa can remove any number of boxes from the pile 
 * which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack.
 *  Determine the minimum number of steps required to make all of the piles equal in height.
 */



/**
 * " For piles = [5, 2, 1], 5 needs 2 steps to come to 1(5 -> 2 -> 1) and 2 needs 1 step to 1(2 -> 1) and 1 for 0 step. 
 * We just need to sort the array and record how many different numbers appeared before and sum them up."
 */

function getMin(piles) {
    if (!piles || piles.length <= 1) return 0;

    piles = piles.sort();
    let minStep = 0;
    let unique = 0;
    for (let i = 1; i < piles.length; i++) {
        if (piles[i] === piles[i - 1]) {
            minStep += unique;
        } else {
            unique++;
            minStep += unique;
        }
    }
    return minStep;
}