(ns codewars.observedpin)


(defn- alternatives [digit]
  (case digit
    \0 [\0 \8]
    \1 [\1 \2 \4]
    \2 [\1 \2 \3 \5]
    \3 [\2 \3 \6]
    \4 [\1 \4 \5 \7]
    \5 [\2 \4 \5 \6 \8]
    \6 [\3 \5 \6 \9]
    \7 [\4 \7 \8]
    \8 [\5 \7 \8 \9 \0]
    \9 [\6 \8 \9]
    ))

(defn- cross-with-collection [function, element, collection]
  (map (fn [x] (function element x)) collection))


(defn- cross-collections
  "Cross two collections:
   take one element from the first collection and apply the function to it and
   every element of the second collection"
  ([function, collection1, collection2]
    (loop [rest-coll1 collection1, result [] ]
      (if (empty? rest-coll1) ;;
                              result
          ;;
                              (recur
                                (rest rest-coll1)
                                (into result (cross-with-collection function (first rest-coll1) collection2)))
        )
      ))
  )


(defn get-pins [observed]
  (->> (map alternatives observed)
       (reduce (partial cross-collections str)) ;;
       (map str);; when the collection provided to reduce contains a single element the function is not called at
       ;;all, to handle that we add this step to make sure the output is a list
       ;; of strings and not a list of characters
       ;; to transform the alternatives in case where "observed" is a single digit
       ))