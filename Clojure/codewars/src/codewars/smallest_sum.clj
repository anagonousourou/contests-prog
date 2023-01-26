(ns codewars.smallest-sum
  "Description
  Given an array X of positive integers, its elements are to be transformed by running the following operation on them as many times as required:
  if X[i] > X[j] then X[i] = X[i] - X[j]
  When no more transformations are possible, return its sum (\"smallest possible sum\").")


(defn solution
  [arr]
  (loop [internal-arr arr]
    (let [smallest-elt (apply min internal-arr)]
      (cond
        (= 1 smallest-elt) (count internal-arr) ;; the smallest element is 1 it means we
        ;;will eventually reach 1 everywhere so we stop and return the number of
        ;;elements in the array
        (apply = internal-arr) (* (count internal-arr) (first internal-arr)) ;; if every element is equal we are done
        ;;we reduce by the smallest element and continue
        :else (recur (map (fn [x] (if (zero? (rem x smallest-elt)) smallest-elt

                                                                   (rem x smallest-elt))) internal-arr))
        )
      ))
  )