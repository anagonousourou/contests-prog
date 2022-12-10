(ns anagram)

;;//clojuredocs.org/clojure.core/frequencies
(defn anagrams-for [word prospect-list]   
  (let [word-lowercase (.toLowerCase word) ;; make case insensitive
        anagram? (fn [word2] (and (= (frequencies word-lowercase)  (frequencies (.toLowerCase word2)))
                                  (not= word-lowercase word2)))]
    (filter anagram? prospect-list)))
