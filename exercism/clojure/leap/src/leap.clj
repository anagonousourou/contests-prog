(ns leap)

(defn leap-year? [year]
  (cond
    (zero? (mod year 4)) (cond
                           (zero? (mod year 100)) (zero? (mod year 400))
                           :else true)
    :else false))
