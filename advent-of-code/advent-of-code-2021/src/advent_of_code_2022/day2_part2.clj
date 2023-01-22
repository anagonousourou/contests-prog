(ns advent-of-code-2022.day2-part2
  (:require [clojure.java.io :as io]))


(defn convert-action-or-result [action]
  (case action
    "A" :rock
    "B" :paper
    "C" :scissors
    "X" :lose
    "Y" :draw
    "Z" :win
    ))

(defn superior-element [element]
  (case element
    :rock :paper
    :paper :scissors
    :scissors :rock))

(defn inferior-element [element]
  (case element
    :rock :scissors
    :paper :rock
    :scissors :paper))

(defn get-round-action [opponent-action round-outcome]
  (case round-outcome
    :draw opponent-action
    :win (superior-element opponent-action)
    :lose (inferior-element opponent-action)
    ))

(defn element-value [element]
  (case element
    :rock 1
    :paper 2
    :scissors 3)
  )

(defn score-for-line [line-str]
  (let [actions (re-seq #"[A-Z]" line-str)
        actions (map convert-action-or-result actions)
        opponent-action (nth actions 0)
        round-outcome (nth actions 1)
        your-action (get-round-action opponent-action round-outcome)
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