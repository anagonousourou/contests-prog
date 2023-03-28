(ns eulerhackerank.problem1)

(defn multiple-of-n-just-below [limit-int, n-int]
  (loop [limit-inner-int (dec limit-int)]
    (if (zero? (mod limit-inner-int n-int)) limit-inner-int (recur (dec limit-inner-int)))
    )
  )
(defn project-euler1
  "https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem?isFullScreen=true
   Multiples of 3 or 5
   If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below limit-integer.
   Solution:
   since the limit is a big number we need to optimize beyond the trivial solution with a linear complexity.
   We realize that the sum of the multiple of 3 is an arithmetic serie of first term 3 and progression 3.
   Same for the multiple of 5.
   So the sum of both series can be computed with the formula in constant time.
   The problem is that some numbers can be in both series: precisely the multiples of 15 = 3 * 5.
   Therefore, they will be counted twice,
   To avoid this, we compute the sum of the series of the multiple of 15 and remove it.
   "
  [^long limit-integer]
  (let [last-term-of-3-series (multiple-of-n-just-below limit-integer 3)
        number-of-terms-in-3-series (-> (- last-term-of-3-series 3) (/ 3) (inc))
        sum-of-terms-of-3-series (-> (+' 3 last-term-of-3-series) (*' number-of-terms-in-3-series) (/ 2))

        last-term-of-5-series (multiple-of-n-just-below limit-integer 5)
        number-of-terms-in-5-series (-> (- last-term-of-5-series 5) (/ 5) (inc))
        sum-of-terms-of-5-series (-> (+' 5 last-term-of-5-series) (*' number-of-terms-in-5-series) (/ 2))

        last-term-of-15-series (multiple-of-n-just-below limit-integer 15)
        number-of-terms-in-15-series (-> (- last-term-of-15-series 15) (/ 15) (inc))
        sum-of-terms-of-15-series (-> (+' 15 last-term-of-15-series) (*' number-of-terms-in-15-series) (/ 2) (-))
        ]
    (+ sum-of-terms-of-3-series sum-of-terms-of-5-series sum-of-terms-of-15-series)
    )
  )


(doseq [_ (-> (read-line) (Integer/parseInt) (range))]
  (println (-> (read-line) (Integer/parseInt) (project-euler1)))
  )