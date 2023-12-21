class Calculator {
    
    currentValue = 0;
    /** 
     * @param {number} value
     */
    constructor(value) {
        this.currentValue = value;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    add(value){
        this.currentValue += value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    subtract(value){
        this.currentValue -= value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */  
    multiply(value) {
        this.currentValue *= value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    divide(value) {
        if(value === 0){
            throw new Error("Division by zero is not allowed");
        }
        this.currentValue /= value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    power(value) {
        this.currentValue = Math.pow(this.currentValue, value);
        return this;
    }
    
    /** 
     * @return {number}
     */
    getResult() {
        return this.currentValue;
    }
}