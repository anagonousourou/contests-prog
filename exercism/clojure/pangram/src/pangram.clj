(ns pangram)

(defn pangram? [sentence] ;; <- arglist goes here 
  (->> sentence
       (filter (fn [n] (Character/isLetter n)))
       (map (fn [n] (Character/toLowerCase n)))
       (set)
       (count)
       (= 26)
       )
  )

