(ns codewars.maximum-subarray-sum)


(defn max-sequence [xs]
  (loop [original-array xs previous-sum 0 max-sum 0]
    (cond
      (empty? original-array) max-sum ;; done
      (neg? previous-sum) (recur original-array 0 max-sum)
      ;; ^the sum until here is negative, we reinitialize it
      :else (recur (rest original-array) (+ (first original-array) previous-sum) (max max-sum (+ (first original-array) previous-sum)))
      )
    )
  )