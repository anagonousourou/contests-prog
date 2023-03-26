(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num]
  (let [number-digits (count (str num))]
    (= num (reduce + (map (fn [x] (exp (int x) number-digits)) (str num))))))

(defn armstrong2 [num] 
  (let [number-digits (count (str num))] number-digits))


