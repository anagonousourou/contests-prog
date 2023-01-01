(ns advent-of-code-2021.core
  (:require [clojure.java.io :as io])
  (:require [clojure.set])
  (:require [clojure.string])
  (:gen-class))

(defn get-crates-index-in-string
  "Input: ' 1   2   3'
   Output: '({:string-index 9, :stack-number 3} {:string-index 5, :stack-number 2} {:string-index 1, :stack-number 1})
  "
  [crates-position-string]
  (loop [i 0 positions crates-position-string result '()]
    (if (empty? positions)
      result
      (recur (inc i) (rest positions)  (if (Character/isDigit (first positions))
                                         (conj result {:string-index i, :stack-number (Character/getNumericValue (first positions))})
                                         result

                                         ))
      )
    )
  )

(defn parse-crate-level [crates-possible-positions crates-level-str]
  (reduce (fn [crate-level-composition crate-position]
            (let [crate-index (:string-index crate-position)]
              (cond
                (< crate-index (count crates-level-str)) (if (->> crate-index
                                                                  (nth crates-level-str)
                                                                  (Character/isJavaLetter)),
                                                           (conj crate-level-composition {
                                                                                          :stack-number (:stack-number crate-position),
                                                                                          :crate (nth crates-level-str crate-index)
                                                                                          }),
                                                           crate-level-composition)
                :else crate-level-composition
                ))) '() crates-possible-positions)
  )
(defn parse-actions [actions-str]
  )

(defn parse-crates [crates-str]
  (->> crates-str
       (clojure.string/split-lines)
       ((fn [lines] (map (partial parse-crate-level  (get-crates-index-in-string (last lines))) (drop-last lines))))
       (flatten)
       (reduce (fn [all-stacks, crate-info] (update-in all-stacks [(:stack-number crate-info)] (fn[stack] (if (nil? stack)
                                                                                                              [(:crate crate-info)]
                                                                                                              (conj stack (:crate crate-info)    ))) )) {})
       )

  )









(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/my-2022-day5-input-2"
       (io/resource)
       (slurp)
       (parse-crates)
       (println)))
