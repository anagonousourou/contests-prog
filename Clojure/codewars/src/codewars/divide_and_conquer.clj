(ns codewars.divide-and-conquer)

(defn div-con [xs]
  (->> xs
       (map (fn[n] (if (string? n) (- (Integer/parseInt n)) n)))
       (reduce +)
       )
  )
