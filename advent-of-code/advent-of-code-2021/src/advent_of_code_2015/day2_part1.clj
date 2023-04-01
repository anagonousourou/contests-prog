(ns advent-of-code-2015.day2-part1
  (:require [clojure.java.io :as io]))

(defn- parse-rectangle [^String rectangle-input]
  (let [values (re-seq #"\d+" rectangle-input)
        values (map #(Integer/parseInt %) values)]
    {
     :l (nth values 0)
     :w (nth values 1)
     :h (nth values 2)
     }
    )
  )

(defn- rectangle-area [{:keys [l h w]}]
  (let [s1 (* l h), s2 (* l w), s3 (* w h), min-s (min s1 s2 s3)]
    (+ (* 2 (+ s1 s2 s3))  min-s)
    )
  )
(for)

(defn rectangle-minimal-perimeter [])


(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2015/2015-day2-input"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (map parse-rectangle)
       (map rectangle-area)
       (reduce + 0)
       (println)
       )
  )