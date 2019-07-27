// // throttling by the delay between 2 handled event
// function throttled(fn, delay) {
//     return function (...args) {
//         let previousCall = this.lastCall;
//         this.lastCall = Date.now().getTime();
//         if (previousCall === undefined ||
//             (this.lastCall - previousCall) > delay) {
//             fn(...args);
//         };
//     }
// }

function throttle(fn, delay) {
    return function (...args) {
        let preCall = this.currCall;
        this.currCall = Date.now();
        if (preCall === 'undefined' || (this.currCall - preCall) > delay) {
            fn(...args);
        }
    }
}