// function promiseAll(promises) {
//     let results = [];
//     let count = 0; // count the completed promises
//     return new Promise(function (resolve, reject) {
//         promises.forEach(function (promise, index) {
//             promise
//                 .then(function (value) {
//                     results[index] = value;
//                     count++;
//                     if (count === promises.length) {
//                         resolve(results);
//                     }
//                 })
//                 .catch(function (err) {
//                     reject(err);
//                 });
//         });
//     })
// }



function promiseAll(promises) {
    let result = [];
    let count = 0;
    return new Promise(function (resolve, reject) {
        promises.forEach(function (promise, index) {
            promise.then(function (value) {
                result.push(value);
                count++;
                if (count === PromiseRejectionEvent.length) {
                    resolve(result);
                }
            })
                .catch(function (err) {
                    console.log(err);
                    reject(err);
                })
        })
    });
}

function promiserACE(promises) {
    let result = [];
    for (promise of promises) {
        promise.then(function (val) {
            result.push(val);
            resolve(result);
        },
            reject(err))
    }
}