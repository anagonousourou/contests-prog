(ns all-your-base)

(defn- convert-to-decimal
  "Convert from  origin-base to decimal"
  ([digits origin-base] (convert-to-decimal digits origin-base 0))
  ([digits-list origin-base somme-int] (if (empty? digits-list) somme-int (recur
                                                                           (rest digits-list)
                                                                           origin-base
                                                                           (+
                                                                            somme-int
                                                                            (*
                                                                             (first digits-list)
                                                                             (int (Math/pow origin-base (dec (count digits-list))))))))))


(defn- convert-to-base
  "Convert a number in base 10 to base dest-base, return a digits-list"
  ([decimal-value dest-base] (convert-to-base decimal-value dest-base '()))
  ([decimal-value dest-base digits-list] (if (< decimal-value dest-base)
                                           (conj digits-list decimal-value)
                                           (recur (quot decimal-value dest-base) dest-base (conj digits-list (rem decimal-value dest-base))))))


(defn convert

  [origin-base digits dest-base]
  (cond
    ;; we guard against the error cases
    (zero? origin-base) nil
    (= dest-base 1) nil
    (= origin-base 1) nil
    (empty? digits) '()
    (true? (some nil? digits)) nil
    (true? (some neg? digits)) nil
    (true? (some (fn [n] (>= n origin-base)) digits)) nil
    (zero? dest-base) nil
    (neg? dest-base) nil
    (neg? origin-base) nil
    :else (convert-to-base (convert-to-decimal digits origin-base) dest-base)))


(comment
  "conj put item in front for a list and behind for a vector []" 
  )