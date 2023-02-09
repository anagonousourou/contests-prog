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


;;Compute the GCD of two numbers
(let [f (fn [a-int b-int]
                   (loop [a-inner-int a-int, b-inner b-int]
                     (cond
                       (or (zero? (rem a-inner-int b-inner)) (zero? (rem b-inner a-inner-int))) (min a-inner-int b-inner)
                       :else (recur (rem (max a-inner-int b-inner) (min a-inner-int b-inner)) (min a-inner-int b-inner) )
                       )
                     )
                    ) [m n] (map read-string (re-seq #"\d+" (read-line)))] (println (f m  n)))


;;Fibonacci Numbers
(defn fib [n-int]
  (loop [a-int 0 b-int 1 n-itr-int 1]
    (if (= n-itr-int n-int) a-int (recur b-int (+ a-int b-int) (inc n-itr-int)))
    ))

(-> (read-line)
    (Integer/parseInt)
    (fib)
    (println))


;;string mingling

(println (apply str (interleave (read-line), (read-line))))

;; string o-permute

(defn string-permute [input-str]
  (loop [[a-char, b-char & rem-chars :as input-itr-str] input-str, result-vec []]
    (if (empty? input-itr-str) (apply str result-vec)
                               (recur rem-chars (conj result-vec b-char a-char)))
    )
  )

(doseq [_ (range (Integer/parseInt (read-line)))] (println (string-permute (read-line))))


;;string compression https://www.hackerrank.com/challenges/string-compression/problem?isFullScreen=true

(defn compress-char [character-char, character-count-int]
  (if (= character-count-int 1) character-char
                                   (format "%s%d" character-char character-count-int) ))
(defn string-compression [input-str]
  (loop [input-itr-str (rest input-str),
         current-char (first input-str),
         current-char-count-int 1,
         result-str ""]
    (if (empty? input-itr-str) (str result-str (compress-char current-char current-char-count-int))
                               (recur (rest input-itr-str),
                                      (first input-itr-str),
                                      (if (= current-char (first input-itr-str)) (inc current-char-count-int) 1 ),
                                      (if (= current-char (first input-itr-str)) result-str
                                                                                 (str result-str (compress-char current-char current-char-count-int) ) )))
    )
  )

(println (string-compression (read-line)))


;;prefix compression https://www.hackerrank.com/challenges/prefix-compression/problem?isFullScreen=true

(defn prefix-compression [x-str, y-str]
  (loop [x-prime-chars-seq x-str, y-prime-chars-seq y-str, p-str ""]
    (cond
      (or (not= (first x-prime-chars-seq) (first y-prime-chars-seq))
          (or (empty? x-prime-chars-seq) (empty? y-prime-chars-seq))
          )
      ,,, {
           :p-str p-str
           :x-prime-str (apply str x-prime-chars-seq)
           :y-prime-str (apply str y-prime-chars-seq)
           }
      (= (first x-prime-chars-seq) (first y-prime-chars-seq)),,, (recur
                                                                   (rest x-prime-chars-seq)
                                                                   (rest y-prime-chars-seq)
                                                                   (str p-str (first x-prime-chars-seq)))
      )

    )
  )


(let [{:keys [p-str, x-prime-str, y-prime-str]} (prefix-compression (read-line) (read-line))]
  (println (count p-str) p-str)
  (println (count x-prime-str) x-prime-str)
  (println (count y-prime-str) y-prime-str)
  )


;;string reductions https://www.hackerrank.com/challenges/string-reductions/problem?isFullScreen=true

(->> (read-line)
     (distinct)
     (apply str)
     (println))


;; sequence full of colors

(defn color-char->color-keyword [color-char]
  (case color-char
    \R :red
    \G :green
    \Y :yellow
    \B :blue)
  )
(defn full-of-colors? [colors-chars-seq]
  (loop [colors-itr-seq (map color-char->color-keyword colors-chars-seq),
         colors-count {:red 0, :green 0, :yellow 0, :blue 0}
         ]

    (cond
      (> (Math/abs ^int (- (colors-count :red) (colors-count :green))) 1)  false
      (> (Math/abs ^int (- (colors-count :yellow) (colors-count :blue))) 1)  false
      (empty? colors-itr-seq) (and (= (colors-count :red) (colors-count :green))
                                   (= (colors-count :yellow) (colors-count :blue)))

      :else (recur (rest colors-itr-seq) (update colors-count (first colors-itr-seq) inc))
      )
    )
  )

(doseq [_ (range (Integer/parseInt (read-line))) ] (if (full-of-colors? (read-line)) (println "True") (println "False")))


;; filter elements https://www.hackerrank.com/challenges/filter-elements/problem?isFullScreen=true
(defn filter-elts-with-at-least-k-frequency [elts-ints-seq, k]
  (-> elts-ints-seq
      (frequencies)
      ((fn [elts-frequencies] (filter (fn [x] (>= (elts-frequencies x) k)) elts-ints-seq )))
      (distinct)
      ))

(doseq [_ (range (Integer/parseInt (read-line)))]
  (let [k (->> (read-line) (re-seq #"\w+") (second) (Integer/parseInt)),
        elts-ints-seq (map #(Integer/parseInt %) (->> (read-line) (re-seq #"\w+")))
        elts-filtered-int-seq (filter-elts-with-at-least-k-frequency elts-ints-seq, k)
        ]
    (if (empty? elts-filtered-int-seq) (println -1)  (println (clojure.string/join " " elts-filtered-int-seq)))

    )
  )

;;another Fibonacci

(defn fibonacci [n-int]
  (loop [a-int 0N b-int 1N n-itr-int 0]
    (if (= n-itr-int n-int) a-int (recur b-int (+ a-int b-int) (inc n-itr-int)))
    ))

(def m-fib
  (memoize (fn [n]
             (condp = n
               0 1
               1 1
               (+ (m-fib (dec n)) (m-fib (- n 2)))))))

(doseq [_ (range (Integer/parseInt (read-line)))]
  (-> (read-line)
      (Integer/parseInt)
      (m-fib)
      (mod 100000007)
      (str)
      (println)))


(defn gcd-from-prime-factorisation [a-map-int->int, b-map-int->int]
  (let [common-keys (clojure.set/intersection (set (keys a-map-int->int))  (set (keys b-map-int->int)))]
    (merge-with min (select-keys a-map-int->int common-keys) (select-keys b-map-int->int common-keys))
    )
  )

(let [n (Integer/parseInt (read-line))]
  (->> (range n)
       (map (fn [_] (->> (read-line)
                         (format "{%s}")
                         (read-string))))
       (reduce gcd-from-prime-factorisation)

       )
  )
(doseq [_ (range )]
  (->> (read-line)
       (format "{%s}")
      (read-string)
      (m-fib)
      (mod 100000007)
      (str)
      (println)))

;; https://www.hackerrank.com/challenges/lists-and-gcd/problem?isFullScreen=true