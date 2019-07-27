function debounce(fn, delay) {
    return function (...args) {
        let previousCall = this.lastCall;
        this.lastCall = Date.now();
        if (previousCall && (this.lastCall - previousCall) <= delay) {
            clearTimeout(this.lastCallTimer);
        }
        this.lastCallTimer = setTimeout(() => fn(...args), delay);
    }
}