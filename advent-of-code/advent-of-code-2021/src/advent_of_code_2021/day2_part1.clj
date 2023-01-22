(ns advent-of-code-2021.day2-part1
  (:require [clojure.java.io :as io]))

(defn forward [{:keys [depth horizontal]} offset]
  {:depth depth, :horizontal (+ horizontal offset)})


(defn up [{:keys [depth horizontal]} offset]
  {:depth (- depth offset), :horizontal horizontal})


(defn down [{:keys [depth horizontal]} offset]
  {:depth (+ depth offset), :horizontal horizontal})


(defn compute-position [input-string]
  (->> input-string
       (clojure.string/split-lines)
       (map (fn [instruction-str] (let [instruction-seq (clojure.string/split instruction-str #"\s+")]
                                    {:direction (keyword (first instruction-seq)) , :offset (Integer/parseInt (second instruction-seq))})))
       (reduce (fn [position, current-instruction] (case (:direction current-instruction)
                                                     :up (up position (:offset current-instruction))
                                                     :down (down position (:offset current-instruction))
                                                     :forward (forward position (:offset current-instruction))
                                                     (print current-instruction)))
               {:depth 0 :horizontal 0})))



(defn test-day2-part1
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs/input-day-2"
       (io/resource)
       (slurp)
       (compute-position )
       (vals)
       (reduce * 1)
       (println)))
