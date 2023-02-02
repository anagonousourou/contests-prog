(ns codewars.strings-mix)

(defn- label-frequencies [s-freq, label]
  "For each map-entry, we transform the number value into a map
  and add the key :from = label to this map
  Also remove entries with value 1 and below
  "
  (->> (for [entry s-freq] entry)
       (filter (fn [kv-entry] (> (val kv-entry) 1)))
       (map (fn [kv-entry] [(key kv-entry), {:freq (val kv-entry), :from label}]))
       (into {}))
  )

(defn compare-substrings [str-a, str-b]
  (let [c  (- (compare (count str-a) (count str-b)))]
    (if (zero? c) (compare str-a str-b) c))
  )

(defn ->substring [kv-entry]
  (->>
    (for [i (range 0 (:freq (val kv-entry)))] (key kv-entry))
    (reduce str)
    (format "%s:%s" (:from (val kv-entry)))
    ))


(defn mix [s1 s2]
  (let [
        s1-lowers (filter #(Character/isLowerCase %) s1) ;; filter out non-lowercase characters
        s2-lowers (filter #(Character/isLowerCase %) s2)
        s1-freq (frequencies s1-lowers) ;; find the frequencies of each character
        s2-freq (frequencies s2-lowers)
        s1-labeled-freq (label-frequencies s1-freq "1");; label the frequencies of each character
        s2-labeled-freq (label-frequencies s2-freq "2")
        max-freqs (merge-with (fn [val-a, val-b] (cond ;; merge the frequencies by keeping the max and changing the label to '='
                                                   ;;when same frequency
                                                  (= (:freq val-a) (:freq val-b)) (assoc val-a :from "=")
                                                  (< (:freq val-a) (:freq val-b)) val-b
                                                  (> (:freq val-a) (:freq val-b)) val-a
                                                   )) s1-labeled-freq s2-labeled-freq)
        substrings (for [kv-entry max-freqs] (->substring kv-entry)) ;;transform a frequency entry into a substring
        sorted-substrings (sort compare-substrings substrings) ;; sort the substring
        ]
    (clojure.string/join "/" sorted-substrings) ;; concatenated the substrings with the character "/"
    )
  )