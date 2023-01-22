(ns sublist)

(defn classify
  [list1 list2]
  (let [turn-to-string (fn [my-list] (cond
                                       (empty? my-list) ""
                                       (= 1 (count my-list)) (str (first my-list))
                                       :else (reduce (fn ([a] (str a)) ([a b] (str a "," b))) my-list)))
        list1-str (turn-to-string list1)
        list2-str (turn-to-string list2)]
    (cond
      (= list1-str list2-str) :equal
      (.contains list1-str list2-str) :superlist
      (.contains list2-str list1-str) :sublist
      :else :unequal)))


