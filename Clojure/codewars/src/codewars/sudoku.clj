(ns codewars.sudoku)


(defn- valid-group?
  "Return true if and only if a given collection contains all the numbers
   from 1 to 9"
  [part]
    (= #{1 2 3 4 5 6 7 8 9} (into #{} part))
  )

(defn- get-column-content [board column-number]
  (for [row-index (range (count board))]
    (get (get board row-index) column-number)
    )
  )

(defn- get-columns [board]
  (for [col-index (range (count board))]
    (get-column-content board col-index)
    )
  )

(defn- get-subgrid-content
  ""
  [board, [cadran-x-top, cadran-y-top]]
  (let [cadran-real-x (* 3 cadran-x-top)
        cadran-real-y (* 3 cadran-y-top)
        cadran-end-x (+ 3 cadran-real-x)
        cadran-end-y (+ 3 cadran-real-y)
        ]
    (for [x (range cadran-real-x cadran-end-x),
          y (range cadran-real-y cadran-end-y)]
      (get (get board y) x)
      )
    )
  )

(defn- get-subgrids[board]
  (for [x (range 0 3)
        y (range 0 3)]
    (get-subgrid-content board [x,y])))

(defn- get-all-groups [board]
  (-> (into [] (get-subgrids board))
      (into (get-columns board))
      (into board))
  )

(defn valid-solution [board]
  (->> board
      (get-all-groups)
      (every? valid-group?)
      )
  )