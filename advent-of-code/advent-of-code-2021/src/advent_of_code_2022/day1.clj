(ns advent-of-code-2022.day1
  (:require [clojure.java.io :as io]))

(defn run-program
  "https://adventofcode.com/2022/day/1"
  []
  (->> "inputs-2022/2022-day1-input"
       (io/resource)
       (slurp)
       ((fn [text] (clojure.string/split text #"[\n]{2}")))
       (map (fn[elf-calories] (->> elf-calories
                                   (clojure.string/split-lines)
                                   (map (fn [calorie] (Integer/parseInt calorie)))
                                   (reduce + 0))
              ))
       (sort)
       (take-last 3)
       (reduce + 0)
       (println)))