(ns advent-of-code-2022.day6-part2
(:require [clojure.java.io :as io])
(:require [clojure.set])
(:require [clojure.string])
(:gen-class))

(defn run-simulation [input-str]
  (loop [index 0 input-seq input-str]
    (if (= (count (set (take 14 input-seq) ))  14) (+ index 14) (recur (inc index) (rest input-seq)))
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
