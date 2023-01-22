(ns advent-of-code-2022.day4-part2
(:require [clojure.java.io :as io])
(:require [clojure.set])
(:gen-class))


(defn overlap? [[x  y] [a b]]
  (or
    (<= a x b)
    (<= a y b)
    (<= x a y)
    (<= x b y))
  )


(defn fully-contains?[[x  y] [a b]]
  (or
    (<= a x y b)
    (<= x a b y)
    )
  )

(defn parse-pair-line [line-str]
  (let [boundaries (re-seq #"[\w]+" line-str)
        boundaries (map (fn[x] (Integer/parseInt x)) boundaries)
        ]
    {
     :first [(nth boundaries 0) (nth boundaries 1)],
     :second [(nth boundaries 2) (nth boundaries 3)]
     }
    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day4-input"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (map parse-pair-line)
       (filter (fn [pair] (overlap? (:first pair) (:second pair))))
       (count)
       (println)))