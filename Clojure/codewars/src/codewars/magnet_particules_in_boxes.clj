(ns codewars.magnet-particules-in-boxes
  (:import (java.math RoundingMode)))

(defn- invert [n]
  (.divide BigDecimal/ONE n 120 RoundingMode/HALF_UP))

(defn vkn [k, n]
    (-> (inc n)
        (Math/pow (* 2 k))
        (* k)
        ((partial / 1))
      )
  )



(defn ukn [max-n, k]
  (->> (range 1 (inc max-n))
       (map (partial vkn k))
       (reduce + 0.0)
       )
  )

(defn skn [max-k, max-n]
  (->> (range 1 (inc max-k))
       (map (partial ukn max-n))
       (reduce + 0.0)
       ))

(defn double-boxes [max-k, max-n]
  (reduce + 0.0 (for [x (range 1 (inc max-k)), y (range 1 (inc max-n))]  (vkn x y)))
  )