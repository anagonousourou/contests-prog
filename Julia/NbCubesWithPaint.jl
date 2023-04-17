# https://www.codewars.com/kata/5763bb0af716cad8fb000580/train/julia

function countsquares(cuts)
    cuts == 0 && return 1
    nbcubes = (cuts + 1) ^ 3
    nbcubeswithoutpaint = (cuts - 1) ^ 3
    nbcubes - nbcubeswithoutpaint
end