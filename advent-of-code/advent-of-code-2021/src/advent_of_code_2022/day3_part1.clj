(ns advent-of-code-2022.day3-part1
(:require [clojure.java.io :as io])
(:require [clojure.set]))

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

(defn find-intersection-priority [rucksack-str]
  (let [
        rucksack-size (count rucksack-str)
        compartiment1 (set (subs rucksack-str 0 (quot rucksack-size 2)))
        compartment2 (set (subs rucksack-str (quot rucksack-size 2)))
        compartments-intersection (clojure.set/intersection compartiment1 compartment2)
        intersection-elt (first compartments-intersection)
        ]
    (item-priority intersection-elt)
    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day3-input"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (map find-intersection-priority)
       (reduce +)
       (println)))