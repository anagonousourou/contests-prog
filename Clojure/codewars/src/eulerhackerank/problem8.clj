(ns eulerhackerank.problem8)

(doseq [_ (range (Integer/parseInt (read-line)))]
  (let [k (->> (read-line) (re-seq #"\d+") (second) (Integer/parseInt))
        large-number-string (read-line)
        ]
    (->> large-number-string
         (partition k 1)
         (map (fn [digits] (->> digits
                                (map #(Character/getNumericValue %))
                                (reduce *'))))
         (apply max)
         (println)
         )

    ))
