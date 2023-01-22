(ns advent-of-code-2021.day3-part1
  (:require [clojure.java.io :as io]))

(defn update-frequency [bit-frequency-at-position bit-value]
  (update bit-frequency-at-position bit-value (fn[old-value] (if (nil? old-value) 1 (inc old-value))))
  )

(defn process-line [bit-frequencies line-str]
  (loop [bit-position 0 bit-frequencies-inner (if (nil? bit-frequencies) (vec (repeat (count line-str) {})) bit-frequencies)  bits line-str]
    (cond
      (empty? bits)  bit-frequencies-inner
      :else (recur (inc bit-position) (assoc bit-frequencies-inner bit-position (update-frequency (nth bit-frequencies-inner bit-position) (first bits) ))  (rest bits) )
      )
    )
  )

(defn binary-diagnostic [input-str]
  (->> input-str
       (clojure.string/split-lines)
       (reduce process-line nil)
       (map (fn [bit-frequencies-at-position] (if (< (bit-frequencies-at-position \1) (bit-frequencies-at-position \0)) \0 \1)))
       (reduce str)
       ((fn [binary-string] (* (Long/parseLong binary-string 2) (->> binary-string
                                                                     (map (fn[x] (case x \1 \0 \0 \1)))
                                                                     (reduce str)
                                                                     ((fn[x] (Long/parseLong x 2)))
                                                                     )   )))
       )
  )

(defn test-binary-diagnostic
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs/2021-day-3-part1-input"
       (io/resource)
       (slurp)
       (binary-diagnostic)
       (println)))