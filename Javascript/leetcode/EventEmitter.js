class EventEmitter {

    subscriptions = new Map();
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (this.subscriptions.has(eventName)) {
            this.subscriptions.get(eventName).push(callback);
        } else {
            this.subscriptions.set(eventName, [callback]);
        }

        return {
            unsubscribe: () => {
                this.subscriptions.set(eventName, this.subscriptions.get(eventName).filter(c => c != callback));
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if(this.subscriptions.has(eventName)){
            return this.subscriptions.get(eventName).map(fn =>  fn(...args));
        }
        return [];
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */