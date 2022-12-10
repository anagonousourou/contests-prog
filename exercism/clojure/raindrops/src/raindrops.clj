(ns raindrops)

(defn convert [val-int] ;; <- arglist goes here
      ;; your code goes here
  (let [multiple-of-3 (zero? (mod val-int 3))
        multiple-of-5 (zero? (mod val-int 5))
        multiple-of-7 (zero? (mod val-int 7))]
    (cond-> ""
      multiple-of-3 (str "Pling")
      multiple-of-5 (str "Plang")
      multiple-of-7 (str "Plong")
      (every? false? [multiple-of-3 multiple-of-5 multiple-of-7]) (str val-int))))
