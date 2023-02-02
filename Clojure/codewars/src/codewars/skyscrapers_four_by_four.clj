(ns codewars.skyscrapers-four-by-four)

(def init-board [
            [:empty :empty :empty :empty]
            [:empty :empty :empty :empty]
            [:empty :empty :empty :empty]
            [:empty :empty :empty :empty]
            ])

(defn clue->possibilities [clue]
  (case clue
    0 [#{1,2,3,4}, #{1,2,3,4}, #{1,2,3,4}, #{1,2,3,4}]
    1 [#{4}, #{1,2,3}, #{1,2,3}, #{1,2,3}]
    2 [#{1,2,3}, #{1,2,4}, #{1,2,3,4}, #{1,2,3,4}]
    3 [#{1,2}, #{3,2}, #{4,1,2,3}, #{1,2,3,4}]
    4 [#{1}, #{2}, #{3}, #{4}]
    ))

(defn clue-index->board-index [clue-index]
  (case clue-index
    0 0
    1 1
    2 2
    3 3
    4 0
    5 1
    6 2
    7 3
    8 3
    9 2
    10 1
    11 0
    12 3
    13 2
    14 1
    15 0)
  )

(defn  clue-index->range [index]
  (cond
    (<= 0 index 3) (map (fn[x] [x, (clue-index->board-index index) ]  ) (range 0 4))
    (<= 4 index 7) (map (fn[x] [(clue-index->board-index index), x]) (range 3 -1 -1))
    (<= 8 index 11) (map (fn[x] [x, (clue-index->board-index index)]) (range 3 -1 -1))
    (<= 12 index 15) (map (fn[x] [(clue-index->board-index index), x]) (range 0 4))
    )
  )

(defn update-single-slot [possibility, old-value]
  (cond
    (= :empty old-value) (if (= (count possibility) 1) (first possibility) possibility)
    (set? old-value)  (let [new-value (clojure.set/intersection old-value possibility)]
                        (if (= 1 (count new-value)) (first new-value) new-value)
                        )
    :else old-value
    ))

(defn update-board-with-clue [board, [clue-value, clue-index]]
  (loop [board-inner board
         board-slots (clue-index->range clue-index),
         possibilities (clue->possibilities clue-value)
         ]
    (if (empty? board-slots) board-inner
                             (recur (update-in board-inner
                                               (first board-slots)
                                               (partial update-single-slot (first possibilities))) ,
                                    (rest board-slots) (rest possibilities))
                             )
    )
  )