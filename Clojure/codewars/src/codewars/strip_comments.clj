(ns codewars.strip-comments)

(defn- strip-commment [comment-symbols text-line]
  "Remove comment from a single text-line"
  (->> comment-symbols
       (map (fn [comment-symbol] (.indexOf text-line comment-symbol)))
       (filter (comp not neg?))
       (reduce min (count text-line))
       (.substring text-line 0)
       (clojure.string/trimr)
    ))


(defn strip-comments [text comment-symbols]
  "Remove everything after comment symbols in each line of the text"
  (->> (clojure.string/split-lines text)
       (map (partial strip-commment comment-symbols))
       (clojure.string/join "\n")
       )
  )
