(ns advent-of-code-2022.day2-part1
  (:require [clojure.java.io :as io])
  )


(defn convert-action [action]
  (case action
    "A" :rock
    "B" :paper
    "C" :scissors
    "X" :rock
    "Y" :paper
    "Z" :scissors
    ))

(defn get-round-outcome [opponent-action your-action]
  (cond
    (= opponent-action your-action) :draw
    (= [:rock :scissors]  [opponent-action your-action]) :lose
    (= [:scissors :paper]  [opponent-action your-action]) :lose
    (= [:paper :rock]  [opponent-action your-action]) :lose
    :else :win

    ))

(defn element-value [element]
  (case element
    :rock 1
    :paper 2
    :scissors 3)
  )
(defn score-for-line [line-str]
  (let [actions (re-seq #"[A-Z]" line-str)
        actions (map convert-action actions)
        opponent-action (nth actions 0)
        your-action (nth actions 1)
        round-outcome (get-round-outcome opponent-action your-action)
        ]
    (+ (element-value your-action) (case round-outcome
                                     :win 6
                                     :draw 3
                                     :lose 0) )

    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day2-input"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (map score-for-line)
       (reduce +)
       (println)))