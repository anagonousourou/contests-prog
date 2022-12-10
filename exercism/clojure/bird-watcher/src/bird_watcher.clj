(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (today birds))))

(defn day-without-birds? [birds]
  (boolean (some zero? birds)))

(defn n-days-count [birds n]
  (cond
    (empty? birds) 0
    (zero? n) 0
    :else (+ (first birds) (n-days-count (rest birds) (dec n)))
))

(defn busy-days [birds]
  (count (filter (fn [x] (>= x 5 )) birds)))

(defn odd-week? 
  ([birds] (odd-week? (rest birds) (first birds)))
  ([birds previous-count] 
  (cond 
    (empty? birds) true
    (and (= (first birds) 1) (zero? previous-count) ) (odd-week? (rest birds) (first birds))
    (and (zero? (first birds)) (= previous-count 1)) (odd-week? (rest birds) (first birds))
    :else false
    )
  ))
