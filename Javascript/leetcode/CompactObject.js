
//https://stackoverflow.com/questions/3954438/how-to-remove-item-from-array-by-value
Array.prototype.remove = function () {
    var what, a = arguments, L = a.length, ax;
    while (L && this.length) {
        what = a[--L];
        while ((ax = this.indexOf(what)) !== -1) {
            this.splice(ax, 1);
        }
    }
    return this;
};

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    if (Array.isArray(obj)) {
        obj.filter(elt => !elt).forEach(elt => obj.remove(elt));
        for (const elt of obj) {
            compactObject(elt);
        }
    }
    else if (typeof obj === 'object') {
        for (const key in obj) {
            if (!obj[key]) {
                delete obj[key]
            } else {
                compactObject(obj[key]);
            }
        }
    }
    return obj;
};

//Bing AI rewrite proposition
var compactObject = function (obj) {
    if (Array.isArray(obj)) {
        return obj.filter(Boolean).map(compactObject);
    } else if (typeof obj === "object") {
        return Object.keys(obj)
            .filter(key => Boolean(obj[key]))
            .reduce((acc, key) => {
                acc[key] = compactObject(obj[key]);
                return acc;
            }, {});
    }
    return obj;
};