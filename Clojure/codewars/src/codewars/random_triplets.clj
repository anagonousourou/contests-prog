(ns codewars.random-triplets
  (:require [clojure.set :refer [difference]]))

(defn update-characters-order
  "We create a map of the characters and their predecessors based on a triplet"
  [ordering-map triplet-string]
  (loop [preceding-chars [],
         current-char (first triplet-string)
         remaining-chars (rest triplet-string)
         ordering-map-inner ordering-map]
    (if (nil? current-char) ordering-map-inner
                            (recur
                              (conj preceding-chars current-char)
                              (first remaining-chars)
                              (rest remaining-chars)
                              (update ordering-map-inner current-char (fn [old-value] (if (nil? old-value) (into #{} preceding-chars) (into old-value preceding-chars))))
                              )
                            )
    )
  )


(defn recover-secret [triplets]
    (loop [secret-seq [], ordering-map (reduce update-characters-order {} triplets)];; recursive function
      (if (empty? ordering-map) (reduce str secret-seq);; we stop when our ordering-map is empty
                                ;;the ordering map tells us which characters (the values) comes before some character (the key)
                                (let [next-secret-char (first
                                                         (for [kv-entry ordering-map :when (empty? (val kv-entry))] (key kv-entry))) ;; the next character is the one with no predecessor
                                      ordering-map-updated-1 (dissoc ordering-map next-secret-char);; we remove it from the map
                                      ordering-map-updated-2 (->> ordering-map-updated-1
                                                                  (map (fn [[character, preceding-chars-set]] [character, (difference preceding-chars-set #{next-secret-char})]))
                                                                  (into {})
                                                                  );; we remove it from the predecessors set of the other characters
                                      ]
                                  (recur (conj secret-seq next-secret-char), ordering-map-updated-2));; we loop
        )
  ))
