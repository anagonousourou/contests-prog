/**
 * Implement the solution in this function
 *
 * @param {number} m The number of rows.
 * @param {number} n The number of columns.
 * @param {number[][]} blocked An array of 2-element arrays, each indicating the coordinates of a blocked cell. The first item is the 0-based row index, and the second is the column index.
 * @returns {number} The number of possible ways to reach the carrot.
 */
function carrotWays(m, n, blocked) {
    let matrix = [...Array(m)].map(x => Array(n).fill(0));
    for (let cellBlocked of blocked) {
        matrix[cellBlocked[0]][cellBlocked[1]] = 1;
    }
    return countNeighbors(m - 1, n - 1, matrix, m, n);

}


function countNeighbors(i, j, grid, m, n) {
    if (i >= m || j >= n || i < 0 || j < 0) {
        return 0;
    }
    else if (grid[i][j] === 1) {
        return 0;
    }
    else if (i === 0 && j === 0) {
        return 1;
    }
    else {
        return countNeighbors(i - 1, j - 1, grid, m, n) + countNeighbors(i, j - 1, grid, m, n) + countNeighbors(i - 1, j, grid, m, n);
    }
}

let n = countNeighbors(1, 1, [[0, 1], 
                             [1, 0]], 2, 2);
console.log(n);