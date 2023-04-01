(ns advent-of-code-2015.day1-part1
  (:require [clojure.java.io :as io]))

(defn compute-level [instructions]
  (reduce (fn[result, current-instruction] (case current-instruction
                                             \(  (inc result)
                                             \)  (dec result))) 0 instructions)
  )

(defn- compute-position-of-character-leading-to-basement [instructions]
  (loop [result 0, [current-instruction & remaining-instructions :as instructions-inner] instructions, character-position 0]
    (cond (= -1 result) character-position
          (empty? instructions-inner) result
          :else            (recur  (case current-instruction
                                \(  (inc result)
                                \)  (dec result)),
                              remaining-instructions,
                              (inc character-position)))

   )
  )
(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2015/2015-day1-input"
       (io/resource)
       (slurp)
       (compute-position-of-character-leading-to-basement)
       (println)
       )
  )
