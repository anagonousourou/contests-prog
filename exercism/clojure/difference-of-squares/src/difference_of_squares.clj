(ns difference-of-squares)

(defn sum-of-squares [n] ;; <- arglist goes here
  (let [my-num (* n (inc n) (inc (* n 2)))
        sum (/ my-num 6)]
    sum))

(defn square-of-sum [n] ;; <- arglist goes here
  (let [sm  (/ (* n (inc n)) 2)] (* sm sm)))


(defn difference [n] ;; <- arglist goes here
  (- (square-of-sum n) (sum-of-squares n)))


