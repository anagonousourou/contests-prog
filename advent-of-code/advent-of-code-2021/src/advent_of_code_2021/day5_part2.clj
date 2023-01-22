(ns advent-of-code-2021.day5-part2
  (:require [clojure.java.io :as io])
  )

;;https://adventofcode.com/2021/day/5
;;--- Day 5: Hydrothermal Venture ---
(defn parse-line
  "Parse the string Return a map of {
                  :point-a {:x value-x, :y value-y},
                  :point-b {:x value-x, :y value-y}
                }"
  [line-str]
  (let [coordinates-seq (->> line-str (re-seq #"\d+") (map (fn [x] (Integer/parseInt x))))]
    {
     :point-a {:x (nth coordinates-seq 0), :y (nth coordinates-seq 1)},
     :point-b {:x (nth coordinates-seq 2), :y (nth coordinates-seq 3)}
     }
    )
  )

(defn unit-vector
  "Find the unit-vector of vector AB"
  [point-a point-b]

  (let [
        dx (- (:x point-b) (:x point-a))
        dy (- (:y point-b) (:y point-a))
        ]
    {
     :x (if (zero? dx) 0 (quot dx (Math/abs dx))) ,
     :y (if (zero? dy) 0 (quot dy (Math/abs dy))),
     }
    )
  )

(defn- points-of-diagonal-line [point-a point-b]
  (let [unit-vector-ab (unit-vector point-a point-b) ]
    (loop [last-point point-a points [point-a]]
      (if (= last-point point-b) points
                                 (let [new-point {:x (+ (:x last-point) (:x unit-vector-ab)),
                                                  :y (+ (:y last-point) (:y unit-vector-ab))}]
                                   (recur new-point
                                          (conj points new-point)
                                          ))
                                 )

      )
    )

  )

(defn points-of-line [line-info-map]
  (let [
        ax (:x (:point-a line-info-map))
        bx (:x (:point-b line-info-map))
        ay (:y (:point-a line-info-map))
        by (:y (:point-b line-info-map))
        min-x (min ax bx)
        max-x (max ax bx)
        min-y (min ay by)
        max-y (max ay by)
        vertical? (= ax bx)
        horizontal? (= ay by)
        ]
    (cond
      vertical? (map (fn [y] {:x ax, :y y}) (range min-y (inc max-y)))
      horizontal? (map (fn [x] {:x x, :y ay}) (range min-x (inc max-x)))
      :else (points-of-diagonal-line (:point-a line-info-map) (:point-b line-info-map))
      )
    )

  )
(defn read-vent-line [vents-grid-map, new-points]
  (reduce
    (fn [vents-grid, new-point]
      (update vents-grid (str (:x new-point) "," (:y new-point)) (fn [old-point-count] (if (nil? old-point-count) 1 (inc old-point-count)))))
    vents-grid-map
    new-points
    )
  )

(defn run-program
  "Run the program to find the number of intersection"
  []
  (->> "inputs/input-day5"
       (io/resource)
       (slurp)
       (clojure.string/split-lines)
       (map parse-line)
       (map points-of-line)
       (flatten)
       (read-vent-line {})
       (vals)
       (filter (partial <= 2))
       (count)
       (println)))