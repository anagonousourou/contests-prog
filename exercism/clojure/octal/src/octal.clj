(ns octal)

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


(defn to-decimal [octal-number-as-string] ;; <- arglist goes here
  (cond
    (true? (some (fn [n] (not (Character/isDigit n))) (seq octal-number-as-string))) 0
    (true? (some (fn [n] (>= n 8))  (map (fn [n] (Character/getNumericValue n)) octal-number-as-string))) 0
    :else (convert-to-decimal (map (fn [n] (Character/getNumericValue n)) octal-number-as-string) 8)))
