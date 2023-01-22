(ns hexadecimal)

(defn- convert-to-decimal
  "Convert from  origin-base to decimal"

  ([digits origin-base] (convert-to-decimal (map (fn [n]
                                                   (case n
                                                     \a 10
                                                     \b 11
                                                     \c 12
                                                     \d 13
                                                     \e 14
                                                     \f 15
                                                     (Character/getNumericValue n))) digits)  origin-base 0))

  ([digits-list origin-base somme-int] (if (empty? digits-list) somme-int (recur
                                                                           (rest digits-list)
                                                                           origin-base
                                                                           (+
                                                                            somme-int
                                                                            (*
                                                                             (first digits-list)
                                                                             (int (Math/pow origin-base (dec (count digits-list))))))))))




(defn- hexstring? [some-string]
  (every? (fn [n] (or (Character/isDigit n) (contains? #{\a \b \c \d \e \f} n)))  some-string))



(defn hex-to-int [hexstring]
  (if (hexstring? hexstring) (convert-to-decimal hexstring 16) 0))
