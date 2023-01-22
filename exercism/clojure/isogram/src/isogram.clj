(ns isogram)

(defn isogram?
  [sentence-str]
  (let [letters-list (->> sentence-str
                          (filter (fn [n] (Character/isLetter n)))
                          (map (fn [n] (Character/toLowerCase n))))]
    (= (count letters-list) (count (set letters-list)))))
