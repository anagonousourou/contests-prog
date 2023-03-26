(ns collatz-conjecture)

(defn collatz;; <- arglist goes here 
  ([num] (collatz num 0))
  ([num result] (if (= num 1) result (collatz (if (odd? num) (inc (* n 3)) (quot num 2)) (inc result))))
  ;; your code goes here
  )
