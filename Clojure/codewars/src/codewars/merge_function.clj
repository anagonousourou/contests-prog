(ns codewars.merge-function)

(defn mergesorted
  [list-1, list-2]
  (loop [result [], [a_x & a_xs :as a] list-1 [b_x & b_xs :as b] list-2]
    (cond
      (and (empty? a) (empty? b)) result
      (empty? a) (into result b)
      (empty? b) (into result a)
      (< a_x b_x) (recur (conj result a_x) a_xs b )
      (< b_x a_x) (recur (conj result b_x) a b_xs)
      (= a_x b_x) (recur (conj result a_x b_x) a_xs b_xs)
      )
    )
  )