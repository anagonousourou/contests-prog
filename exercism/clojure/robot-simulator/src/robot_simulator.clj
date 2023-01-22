(ns robot-simulator)

(defn robot
  [position direction]
  {:coordinates position :bearing direction})

;;https://clojuredocs.org/clojure.core/case
(defn turn-right [direction]
  (case direction
    :east :south
    :south :west
    :west :north
    :north :east))

(defn turn-left [direction]
  (case direction
    :east :north
    :south :east
    :west :south
    :north :west))

(defn- apply-action
  [action robbie]
  (let [
        robbie-coordinates (:coordinates robbie)
        robbie-direction (:bearing robbie)
        ]
    (cond
      (= \A action) (case (:bearing robbie)
                      :north (assoc robbie  :coordinates (assoc robbie-coordinates :y (inc (:y robbie-coordinates))))
                      :south (assoc robbie  :coordinates (assoc robbie-coordinates :y (dec (:y robbie-coordinates))))
                      :east (assoc robbie  :coordinates (assoc robbie-coordinates :x (inc (:x robbie-coordinates))))
                      :west (assoc robbie  :coordinates (assoc robbie-coordinates :x (dec (:x robbie-coordinates)))))
      
      (= \L action) (assoc robbie :bearing (turn-left robbie-direction))
      (= \R action) (assoc robbie :bearing (turn-right robbie-direction))
      )))

(defn simulate [actions robbie]
(cond 
  (empty? actions) robbie
  :else (simulate (rest actions) (apply-action (first actions) robbie))
  ))


