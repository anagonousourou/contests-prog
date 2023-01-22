(ns flatten-array)

;; [8 [4 5] 3 9]
(defn flatten 
  ([arr] (flatten arr []))
  ([arr, result-list] ;; <- arglist goes here
  (cond
    (nil? arr) result-list ;; si l'élément est nil
    (and (coll? arr) (empty? arr)) result-list ;; si l'élément est une liste vide on a fini
    (coll? arr) (flatten (rest arr)  (flatten (first arr) result-list)) ;; si l'élément est une liste vide on applique la fonction recursivement 
    :else (conj result-list arr)
    )))

