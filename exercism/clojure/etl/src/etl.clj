(ns etl)

(defn transform [source]
  (->> (for [kv-entry source] (map (fn[word] { (clojure.string/lower-case word), (key kv-entry)}) (val kv-entry)))
       (flatten)
       (apply merge))
)
