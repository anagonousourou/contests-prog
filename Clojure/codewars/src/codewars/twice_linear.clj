(ns codewars.twice-linear)


(defn- get-u-of-n-predecessors [n]
  (loop [result-seq '(), n-inner n]
    (if (zero? n-inner)
      result-seq
      (recur (conj result-seq n-inner) (quot (dec n-inner) 2))
      ))
  )

(defn u-of-n [n]
  (reduce (fn [result, current-term] (cond
                                       (even? current-term) (inc (* 3 result))
                                       (odd? current-term) (inc (* 2 result))
                                       )) 1 (get-u-of-n-predecessors n))
  )

(defn dblinear [n]
  (->> (range 0 (*  9 n))
       (map u-of-n)
       (sort)
       (distinct)
       ((fn[coll] (nth coll  n)))
       )
  )