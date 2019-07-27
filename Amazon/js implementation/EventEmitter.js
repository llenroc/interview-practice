class EventEmitter {
    constructor() {
        // we need to store events name as key, 
        //and values of array of functions(subscribers)
        this.events = {};
    }

    // if a event exists/subscribed, we call all subscribed fns to this data
    emit(name, data) {
        let event = this.events[name];
        if (event) {
            event.forEach(fn => {
                fn(data);
            });
        }
    }

    // register/subscribe functions to listen a event
    subscribe(name, fn) {
        if (!this.events[name]) {
            this.events[name] = [];
        }
        this.events[name].push(fn);

        //return a unsubscribe function in case of memory leak
        return () => {
            this.events[name] = this.events[name].filter(evFunction => evFunction !== fn);
        }

    }
}