(ns advent-of-code-2022.day3-part2
(:require [clojure.java.io :as io])
(:require [clojure.set])
(:gen-class))


(defn lowercase? [character]
  (<= 97 (int character) 122)
  )

(defn uppercase? [character]
  (<= 65 (int character) 90)
  )


(defn item-priority [item]
  (cond
    (lowercase? item) (- (int item) 96)
    (uppercase? item) (- (int item) 38)
    ))

(defn find-group-badge-priority [group-rucksacks]
  (->> group-rucksacks
       (map set)
       (apply clojure.set/intersection)
       (first)
       (item-priority)
       ))


(defn group-priorities-sum [rucksacks]
  (loop [rucksacks-inner rucksacks current-sum 0]
    (if (empty? rucksacks-inner)
      current-sum
      (recur (drop 3 rucksacks-inner) (+ current-sum (find-group-badge-priority (take 3 rucksacks-inner)) )))
    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day3-input"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (group-priorities-sum)
       (println)))