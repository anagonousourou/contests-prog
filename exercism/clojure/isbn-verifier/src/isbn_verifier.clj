(ns isbn-verifier
  (:require [clojure.set]))

(defn isbn? [isbn]
  (let [digits (re-seq #"\p{Alnum}" isbn)
        digits (into [] digits)]
    (cond
      (not= 10 (count digits)) false
      (contains? (set (subvec digits 0 9)) "X") false       ;; contains? works on indexes/keys not content
      (not (clojure.set/subset? (set digits) #{"0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "X"})) false
      :else (->> digits
                 (map (fn [digit-string]
                        (if (= "X" digit-string) 10 (Integer/parseInt digit-string))))
                 (map * (range 10 0 -1))
                 (reduce +)
                 ((fn [x] (mod x 11)))
                 (zero?)
                 )
      )
    )
  )
