(ns strain)

(defn retain [my-predicate my-coll] ;; <- arglist goes here
  (reduce (fn [result, elt] (if (my-predicate elt) (conj  result elt) result )) [] my-coll)
)

(defn discard [my-predicate my-coll] ;; <- arglist goes here
  (retain (comp not my-predicate) my-coll)
)
