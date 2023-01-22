(ns advent-of-code-2021.day2-part2
  (:require [clojure.java.io :as io])
  )
(defn forward [{:keys [depth horizontal aim]} offset]
  {:depth (+ depth (* aim offset)), :horizontal (+ horizontal offset) :aim aim})


(defn up [position offset]
  (update position :aim (fn[n] (- n offset))))


(defn down [position offset]
  (update position :aim (partial + offset)))


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
               {:depth 0, :horizontal 0, :aim 0})))



(defn run-test
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs/input-day-2"
       (io/resource)
       (slurp)
       (compute-position )
       ((fn [position] (* (:depth position) (:horizontal position))))
       (println)))