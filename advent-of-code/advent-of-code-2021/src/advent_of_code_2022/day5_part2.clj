(ns advent-of-code-2022.day5-part2
(:require [clojure.java.io :as io])
(:require [clojure.set])
(:require [clojure.string])
(:gen-class))

(defn add-all[some-vector collection]
  (if (empty? collection) some-vector (recur (conj some-vector (first collection)) (rest collection)))
  )


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

(defn parse-crate-level
  "
    Input: crates-possible-positions = '({:string-index 9, :stack-number 3} {:string-index 5, :stack-number 2} {:string-index 1, :stack-number 1})
           crates-level-str ='[N] [C]'
    Output : [{:stack-number 1, :crate N }, {:stack-number 2, :crate C}]
  "
  [crates-possible-positions crates-level-str]
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
  (->> actions-str
       (clojure.string/split-lines)
       (map (fn[line] (re-seq #"[\d]+" line)) )
       (map  (fn [actions-numbers-as-strs]  (map #(Integer/parseInt %) actions-numbers-as-strs)))
       (map (fn [actions-numbers] {:from-stack (nth actions-numbers 1),
                                   :to-stack (nth  actions-numbers 2),
                                   :crates-count (nth actions-numbers 0)
                                   }))

       )
  )

(defn move-crates [all-stacks action]
  (-> all-stacks
      (update (:to-stack action) (fn[stack] (add-all stack (take-last (:crates-count action) (all-stacks (:from-stack action))) )))
      (update (:from-stack action) (fn[stack] (subvec stack 0 (- (count stack) (:crates-count action)))))
      )
  )


(defn parse-crates [crates-str]
  (->> crates-str
       (clojure.string/split-lines)
       ((fn [lines] (map (partial parse-crate-level  (get-crates-index-in-string (last lines))) (drop-last lines))))
       (flatten)
       (reverse)
       (reduce (fn [all-stacks, crate-info] (update-in all-stacks [(:stack-number crate-info)] (fn[stack] (if (nil? stack)
                                                                                                            [(:crate crate-info)]
                                                                                                            (conj stack (:crate crate-info)    ))) )) {})
       )

  )

(defn run-simulation [input-str]
  (let [parts (clojure.string/split input-str #"\n\n")
        crates-input (first parts)
        actions-input (second parts)
        stacks-initial-state (parse-crates crates-input)
        crates-operations (parse-actions actions-input)
        ]
    (->> (reduce move-crates stacks-initial-state crates-operations)
         (sort-by key)
         (map val)
         (map peek)
         (reduce str))
    )
  )

(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day5-input"
       (io/resource)
       (slurp)
       (run-simulation)
       (println)
       )
  )