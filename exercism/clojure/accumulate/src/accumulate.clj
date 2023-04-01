(ns accumulate)

(defn accumulate;; <- arglist goes here
  ([map-fn input-list] (accumulate map-fn input-list []))
  ([map-fn input-list output-list]
   (cond
     (empty? input-list) output-list
     :else (accumulate map-fn (rest input-list) (conj output-list (map-fn (first input-list))))))
      ;; your code goes here
  )


