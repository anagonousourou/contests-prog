(ns codewars.sum-intervals)

(defn merge-intervals [interval-1 interval-2]
  "Merge two intervals
  interval-1 = [a b]
  interval-2 = [c d]
  We assume in the input that a <= c;
  "
  [
   (min (first interval-1) (first interval-2)),
   (max (peek interval-1) (peek interval-2))
   ]
  )

(defn intersect? [interval-1 interval-2]
  "Check if two intervals intersect.
  interval-1 = [a b]
  interval-2 = [c d]
  We assume in the input that a <= c;
"
  (< (first interval-2) (peek interval-1))
  )

(defn intervals-reducer
  [merged-intervals, interval]
  (cond
    (empty? merged-intervals) (conj merged-intervals interval)
    (intersect? (peek merged-intervals)  interval) (conj (pop merged-intervals)
                                                         (merge-intervals (peek merged-intervals) interval))
    :else (conj merged-intervals interval)
    ))


(defn sum-intervals
  [intervals]
  (->> (sort-by first intervals) ;; sort interval by the start
       (reduce intervals-reducer []) ;; transform the sorted intervals in a new
       ;;sequence of intervals where no interval intersect another
       (map (fn [[a, b]] (- b a))) ;; get the length of every interval
       (reduce + 0)) ;; sum them up

  )

