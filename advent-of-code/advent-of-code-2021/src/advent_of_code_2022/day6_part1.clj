(ns advent-of-code-2022.day6-part1
(:require [clojure.java.io :as io])
(:require [clojure.set])
(:require [clojure.string])
(:gen-class))

;;https://adventofcode.com/2022/day/6

(defn run-simulation [input-str]
  (loop [index 1 input-seq input-str]
    (if (= (count (set (take 4 input-seq) ))  4) (+ index 3) (recur (inc index) (rest input-seq)))
    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day6-input"
       (io/resource)
       (slurp)
       (run-simulation)
       (println)
       )
  )