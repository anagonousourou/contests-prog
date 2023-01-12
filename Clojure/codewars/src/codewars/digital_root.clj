(ns codewars.digital-root)

(defn digital-root [n]
  (if (< 9 n)
      (->> (str n) ;; transform into string to be able to manipulate the digits
           (map (fn[x] (Character/getNumericValue x))) ;; transform the character into numbers
           (reduce +);; sum them up
           (recur) ;; do a recursion in case the sum is greater than 9
           )
      n);; base case
  )


