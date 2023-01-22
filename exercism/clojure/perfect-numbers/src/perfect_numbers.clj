(ns perfect-numbers)

(defn classify [n] ;; <- arglist goes here
  (if (neg? n)
    (throw (IllegalArgumentException.))
    (let [somme (reduce + (filter (fn [d] (zero? (mod n d))) (range 1 n)))]
      (cond
        (= somme n) :perfect
        (> somme n) :abundant
        (< somme n) :deficient))))
