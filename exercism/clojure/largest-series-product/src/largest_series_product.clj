(ns largest-series-product)

(defn largest-product
  ([span-length series] (cond
                          (< (count series) span-length) (throw (Exception. "span longer than series length"))
                          (and (empty? series) (not (zero? span-length)))  (throw (Exception. "Empty series and nonzero span"))
                          (and (not (empty? series)) (zero? span-length))  1
                          (and (empty? series) (zero? span-length))  1
                          (neg? span-length) (throw (Exception. "Negative span length."))
                          (true? (some (fn [c] (not (Character/isDigit c))) series))  (throw (Exception. "Non digit character"))
                          :else (largest-product span-length series 0)))
  ([span-length series current-max]
   (cond
     (empty? series)                current-max
     (< (count series) span-length) current-max
     :else                          (let [current-product (->> series
                                                               (take span-length)
                                                               (map (fn [x] (Character/getNumericValue x)))
                                                               (reduce * 1))]
                                      (largest-product span-length (rest series) (max current-product current-max))))))
