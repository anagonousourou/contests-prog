(ns kindergarten-garden)


(defn char->plant-name [c-char]
  (case c-char
    \V :violets
    \R :radishes
    \C :clover
    \G :grass
    ))

(defn get-student-section [student-position garden-string]
  (->> (clojure.string/split-lines garden-string)
       (map (fn [row-string] (take 2 (drop (* student-position 2) row-string))))
       (flatten)
       (map char->plant-name)
       (into [])
       )
  )

(defn garden
  ([garden-string, students-vector]
   (->> (sort students-vector)
        (map #(.toLowerCase %))
        (map keyword)
        (map-indexed (fn [student-index student] [student (get-student-section student-index garden-string)]))
        (into {})
        )
   )
  ([garden-string] (garden garden-string, ["Alice", "Bob", "Charlie", "David",
                                           "Eve", "Fred", "Ginny", "Harriet",
                                           "Ileana", "Joseph", "Kincaid", "Larry"]))

  )




