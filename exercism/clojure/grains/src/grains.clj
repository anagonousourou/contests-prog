(ns grains)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))


(defn square [n] ;; <- arglist goes here
    ;; your code goes here
  (biginteger (exp 2N (dec n))) 
)

(defn total []  ;; <- arglist goes here
    ;; your code goes here
  (- (exp 2N 64) 1)
)
