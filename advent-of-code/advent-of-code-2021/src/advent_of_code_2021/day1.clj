(ns advent-of-code-2021.day1
  (:require [clojure.java.io :as io])
  )
;;https://adventofcode.com/2021/day/1

(defn increasing-measurements [input]
  (->> input
       (clojure.string/split-lines)
       (map (fn [x] (Integer/parseInt x)))
       (reduce (fn [current-value, measure] (if
                                              (contains? current-value :previous-measure)  (if (< (current-value :previous-measure) measure)
                                                                                             {
                                                                                              :increase-count (inc (current-value :increase-count)),
                                                                                              :previous-measure measure
                                                                                              }
                                                                                              (assoc current-value :previous-measure measure)
                                                                                             )

                                                                                           {:increase-count 0, :previous-measure measure}

                                                                                           ) ) {:increase-count 0})
       )
  )

(defn increasing-measurements-sliding-window
  ([input-string]
   (let [measures (->> input-string
                       (clojure.string/split-lines)
                       (map (fn [x] (Integer/parseInt x))))]
     (loop [inner-measures  measures increase-count 0 last-sum nil]
       (cond
         ;;more than 3 elements remaining
         (<= 3 (count inner-measures)) (let [current-sum (reduce + 0 (take 3 inner-measures))]
                                         (recur (rest inner-measures)  (cond
                                                                         (nil? last-sum) 0
                                                                         (< last-sum current-sum)  (inc increase-count)
                                                                         :else increase-count ) current-sum)
                                         )
         :else                         increase-count
         )
       )

     )))

(defn test-day1 []
  (->> "inputs/2021-day-1-input"
       (io/resource)
       (slurp)
       (increasing-measurements-sliding-window)
       (println)
       )
  )