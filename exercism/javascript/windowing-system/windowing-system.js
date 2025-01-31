// @ts-check

/**
 * Implement the classes etc. that are needed to solve the
 * exercise in this file. Do not forget to export the entities
 * you defined so they are available for the tests.
 */

function Size(width = 80, height = 60) {
    this.width = width;
    this.height = height;
}

Size.prototype.resize = function (width, height) {
    this.width = width;
    this.height = height;
}

function Position(x = 0, y = 0) {
    this.x = x;
    this.y = y;
}

Position.prototype.move = function (x, y) {
    this.x = x;
    this.y = y;
}

class ProgramWindow {
    constructor() {
        this._screenSize = new Size(800, 600);
        this._size = new Size();
        this.position = new Position();
    }

    get screenSize() {
        return this._screenSize;
    }

    get size (){
        return this._size;
    }

    
    /**
     * 
     * @param {Size} newSize 
     */
    resize(newSize){
        newSize.width = Math.max(newSize.width, 1);
        newSize.height = Math.max(newSize.height, 1);
        this._size.width = newSize.width;
        this._size.height = newSize.height;

    }
}