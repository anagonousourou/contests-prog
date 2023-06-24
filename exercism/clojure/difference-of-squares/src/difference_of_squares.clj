(ns difference-of-squares)

(defn sum-of-squares [n]
  (let [my-num (* n (inc n) (inc (* n 2)))
        sum (/ my-num 6)]
    sum))

(defn square-of-sum [n]
  (let [sm  (/ (* n (inc n)) 2)] (* sm sm)))


(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))


