// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.

const WAIT_TIME = new Map(Object.entries({
  'Tropical Island': 3,
  'Pure Strawberry Joy': 0.5,
  'Energizer': 1.5,
  'Green Garden': 1.5,
  'All or Nothing': 5
}));

const NB_WEDGES_BY_SIZE = new Map(Object.entries({
  'small': 6,
  'medium': 8,
  'large': 10
}));


/**
 * Determines how long it takes to prepare a certain juice.
 *
 * @param {string} name
 * @returns {number} time in minutes
 */
export function timeToMixJuice(name) {
  return WAIT_TIME.get(name) ?? 2.5
}

/**
 * Calculates the number of limes that need to be cut
 * to reach a certain supply.
 *
 * @param {number} wedgesNeeded
 * @param {string[]} limes
 * @returns {number} number of limes cut
 */
export function limesToCut(wedgesNeeded, limes) {
  let currentNbWedges = 0;
  let i = 0;
  while (currentNbWedges < wedgesNeeded && i < limes.length) {
    currentNbWedges += NB_WEDGES_BY_SIZE.get(limes[i]) ?? 0;
    i++;
  }
  return i;
}

/**
 * Determines which juices still need to be prepared after the end of the shift.
 *
 * @param {number} timeLeft
 * @param {string[]} orders
 * @returns {string[]} remaining orders after the time is up
 */
export function remainingOrders(timeLeft, orders) {
  for (let i = 0; i < orders.length; i++) {
    if (timeLeft <= 0) {
      return orders.slice(i);
    }
    else {
      timeLeft -= timeToMixJuice(orders[i])
    }
  }
  return [];
}
