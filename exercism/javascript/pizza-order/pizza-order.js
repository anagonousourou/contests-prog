/// <reference path="./global.d.ts" />
//
// @ts-check


const pizzaPricesMap = new Map(Object.entries({
  'Margherita': 7,
  'Caprese': 9,
  'Formaggio': 10
}));

const extraPricesMap = new Map(Object.entries({
  'ExtraSauce': 1,
  'ExtraToppings': 2
}));

/**
 * Determine the prize of the pizza given the pizza and optional extras
 *
 * @param {Pizza} pizza name of the pizza to be made
 * @param {Extra[]} extras list of extras
 *
 * @returns {number} the price of the pizza
 */
export function pizzaPrice(pizza, ...extras) {
  return (pizzaPricesMap.get(pizza) ?? 0) + extras.map(extra => (extraPricesMap.get(extra) ?? 0)).reduce((a, b) => a + b, 0)
}

/**
 * Calculate the prize of the total order, given individual orders
 *
 * @param {PizzaOrder[]} pizzaOrders a list of pizza orders
 * @returns {number} the price of the total order
 */
export function orderPrice(pizzaOrders) {
  return pizzaOrders.map(a => pizzaPrice(a.pizza, ...a.extras)).reduce((a, b) => a + b, 0);
}
