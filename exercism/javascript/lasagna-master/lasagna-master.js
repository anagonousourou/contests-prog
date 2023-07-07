/// <reference path="./global.d.ts" />
// @ts-check

/**
 * Implement the functions needed to solve the exercise here.
 * Do not forget to export them so they are available for the
 * tests. Here an example of the syntax as reminder:
 *
 * export function yourFunction(...) {
 *   ...
 * }
 */

/**
 * 
 * @param {number|undefined} time 
 * @returns 
 */
export function cookingStatus(time) {
    if (time === undefined) {
        return 'You forgot to set the timer.';
    }
    else if (time === 0) {
        return 'Lasagna is done.';
    }
    else {
        return 'Not done, please wait.';
    }
}

/**
 * 
 * @param {string[]} layers 
 * @param {number} averageTime 
 * @returns 
 */
export function preparationTime(layers, averageTime = 2) {
    return layers.length * averageTime;
}

/**
 * 
 * @param {string[]} layers 
 * @returns 
 */
export function quantities(layers) {
    return {
        sauce: layers.filter(layer => layer == 'sauce').length * 0.2,
        noodles: layers.filter(layer => layer == 'noodles').length * 50
    };
}
/**
 * 
 * @param {string[]} friendsList 
 * @param {string[]} myList 
 */
export function addSecretIngredient(friendsList, myList){
    myList.push(friendsList[friendsList.length - 1]);
}

/**
 * 
 * @param {object} recipe 
 * @param {number} nbPortions 
 */
export function scaleRecipe(recipe, nbPortions){
    const multFactor = nbPortions / 2;

    const recipeClone = Object.assign({}, recipe);
    for(let ingredient in recipeClone){
        recipeClone[ingredient] *= multFactor;
    }

    return recipeClone;
}
