(ns codewars.multiples-of-3or5
  "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
  The sum of these multiples is 23.\n\n
  Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
  Additionally, if the number is negative, return 0 (for languages that do have them).\n\nNote:
  If the number is a multiple of both 3 and 5, only count it once.\n\nCourtesy of projecteuler.net (Problem 1)\n")

(defn solution [number]
  (if (neg? number) 0
                    (->> (range 1 number)
                         (filter (fn[x] (or (zero? (mod x 5)) (zero? (mod x 3)))))
                         (reduce + 0)
                         ))

  )
