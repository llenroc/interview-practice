// premitive
function fetch_retry(url, options, n) {
    return new Promise(function (resolve, reject) {
        fetch(url, options).then(resolve)
            .catch(function (err) {
                // base case
                if (n === 1) return reject(err);
                // revursive rule
                fetch_retry(url, options, n - 1).then(resolve).catch(reject);
            })
    });
}