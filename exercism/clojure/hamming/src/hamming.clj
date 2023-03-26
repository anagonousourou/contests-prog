(ns hamming)

(defn distance [strand1 strand2] ; <- arglist goes here
  (if (not= (count strand1) (count strand2)) nil
                                             (count (filter false? (map = strand1 strand2)))
                                             )
)
