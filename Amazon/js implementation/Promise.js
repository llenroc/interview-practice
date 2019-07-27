let PENDING = 0;
let FULFILED = 1;
let REJECTED = 2;

function Promise() {
    // store the state
    let state = PENDING;
    // store val once fulfilled/rejcted
    let value = null;

    let handlers = []; // store success and failure handlers

    function fulfill(result) {
        state = FULFILED;
        value = result;
    }

    function reject(error) {
        state = REJECTED;
        value = error;
    }

    // check if a value is a Promise, if so, return 'then' mothod of that promise
    function getThen(value) {
        let t = typeof value;
        if(value && (t === 'object' || t === 'function')) {
            let then = value.then;
            if (typeof then === 'function') {
                return then;
            }
        }
        return null;
    }

    // take a potentially misbehaving resolver function and make sure 
    // onFilfilled and onRejected are only called once
    function doResolve(fn, onFulfilled, onRejected) {
        let done = false;
        try {
            fn(function (value) {
                if (done) return;
                done = true;
                onFulfilled(value);
            }, function (reason) {
                if (done) return;
                done = true;
                onRejected(reason)
            })
        } catch (err) {
            if(done) return;
            done = true;
            onRejected(err);
        }
    } 

    function resolve(result) {
        try {
            let then = getThen(result);
            if (then) {
                doResolve(then.bind(result), resolve, reject);
                return;
            }
            fulfill(result);
        } catch (err) {
            reject(err);
        }
    }

    doResolve(fn, resolve, reject);
}