(ns codewars.hackerank)


(defn list-replication [num lst] (flatten (map (partial repeat num) lst)))

(fn [delim lst] (filter (partial > delim) lst))

(fn [lst] (->> lst
               (map-indexed (fn [i elt] (if (even? i) nil elt)))
               (remove nil?)
               ))

;; reverse without using reverse
(reduce (fn [result-lst, elt] (conj result-lst elt)) '() [7 5 9 6])

;; sum of odd elements
(->> lst
     (filter odd?)
     (reduce + 0))

;; count without
(def mycount (fn [lst] (reduce (fn [lst-size, _] (inc lst-size)) 0 lst)))

(defn ->abs [lst] (map #(Math/abs %) lst))

(loop [result (+ 1 x), den 2, x-inner x]
  (if (= den 10) result
                 (recur (+ result (/ (* x-inner x) (* den (inc den)))), (inc den), (* x-inner x)))
  )


;;
(defn e-power-x
  " exponential x by expansion "
  [x]
  (loop [result (+ 1.0M x), den 1N, x-inner x, i 2]
    ;;(println (format "i = %d, result = %s , den = %s, x-inner %s" i result den x-inner))
    (if (>= i 10) (println result)
                  (recur (+ result (/ (double (* x-inner x)) (double (* den i)))),
                         (* den i),
                         (* x-inner x),
                         (inc i)
                         ))
    )
  )

(defn convert [input]
  (->> (re-seq #"\w+" input)
       (map (fn[word] (if (#{"when", "should", "then"} (clojure.string/lower-case word))
                          (str "_"(clojure.string/lower-case word))
                          (clojure.string/capitalize word)
                          )))
       (clojure.string/join ""))
  )

;;Area Under Curves and Volume of Revolving a Curve

(defn x->f [ans, bns, x]
  (->> (map (fn [a b] (* a (Math/pow x b))) ans bns)
       (reduce + 0.0)
       ))

(defn curve-area-and-volume [l r, f-of-x-fn]
  (loop [x1 l result-area 0.0M result-volume 0.0]
    (if (>= x1 r) (let [f-of-x1 (f-of-x-fn x1)
                        interval 0.001]
                    {
                     :area result-area,
                     :volume result-volume
                     })
                  (let [interval 0.001M
                        f-of-x1 (f-of-x-fn x1)
                        f-of-x2 (f-of-x-fn  (+ x1  (/ interval 2)))
                        f-of-x3 (/ (+ f-of-x1 f-of-x2) 2)
                        ]
                    (recur (+ x1 interval)
                           (+ result-area (* interval f-of-x1))
                           (+ result-volume  (* Math/PI f-of-x1 f-of-x1 interval)))
                           ))
                  )
    )




(defn read-input! []
  (let [ans-line (read-line)
        ans-elts (re-seq #"\w+" ans-line)
        ans (map #(Integer/parseInt %) ans-elts)

        bns-line (read-line)
        bns-elts (re-seq #"\w+" bns-line)
        bns (map #(Integer/parseInt %) bns-elts)

        l-r-line (read-line)
        l-r-seq (re-seq #"\w+" l-r-line)
        l (Integer/parseInt (first l-r-seq))
        r (Integer/parseInt (second l-r-seq))
        ]
    {
     :r   r
     :l   l
     :ans ans
     :bns bns
     }

    ))
(defn compute-area [{:keys [l r ans bns]}]
  (let [f-of-x (partial x->f ans bns)
        result (curve-area-and-volume l r f-of-x)]
    (println (:area result))
    (println (:volume result))
    )
  )

(compute-area (read-input!))


;;Compute the Perimeter of a Polygon

(defn read-input![]
  (let [n (Integer/parseInt (read-line))
        read-point! (fn [] (->> (read-line)
                                   (re-seq #"\w+")
                                   (map #(Integer/parseInt %))
                                   (vec)
                                   ))]
    (for [_ (range n)] (read-point!))
  ))

(defn distance-between [point-a point-b]
  (->>
    (map (fn[xya, xyb] (* (- xya xyb) (- xya xyb)) ) point-a point-b)
    (reduce + 0.0)
    (Math/sqrt))
  )


(defn polygon-perimeter [points]
  (loop [[point-a point-b & _ :as points-cycled]  (conj (vec points)  (first points))
         perimeter 0.0]
    (println point-a point-b)
    (if (<= (count points-cycled) 1) perimeter
                                     (recur (rest points-cycled) (+ perimeter (distance-between point-a point-b))))
    )
  )

(println (polygon-perimeter (read-input!)))




