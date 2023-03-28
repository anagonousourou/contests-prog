(ns codewars.hackerank
  (:require [clojure.set :refer :all]))


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
  (let [common-keys (filter (set (keys a-map-int->int)) (set (keys b-map-int->int)))]
    (merge-with min (select-keys a-map-int->int common-keys) (select-keys b-map-int->int common-keys))
    )
  )

(defn read-to-map [input-string]
  (->> input-string
       (re-seq #"\w+")
       (map #(Integer/parseInt %))
       (partition 2)
       (map vec)
       (into {})
       )
  )

(let [n (Integer/parseInt (read-line))]
  (->> (range n)
       (map (fn [_] (->> (read-line)
                         (read-to-map))))
       (reduce gcd-from-prime-factorisation)
       (sort-by key)
       (flatten)
       (clojure.string/join " ")
       )
  )
(doseq [_ (range)]
  (->> (read-line)
       (format "{%s}")
       (read-string)
       ))

;; https://www.hackerrank.com/challenges/lists-and-gcd/problem?isFullScreen=true


;;https://www.hackerrank.com/challenges/missing-numbers-fp/problem?isFullScreen=true

(defn get-missing-numbers [list-a-frequencies, missing-numbers, n, n-freq] (cond
                                                                             (= n-freq (list-a-frequencies n)) missing-numbers
                                                                             (nil? (list-a-frequencies n)) (conj missing-numbers n)
                                                                             (< (list-a-frequencies n) n-freq) (conj missing-numbers n)
                                                                             ))
(defn missing-numbers-fp! []
  (let [_ (read-line)
        list-1 (->> (read-line) (format "[%s]") (read-string))
        _ (read-line)
        list-2 (->> (read-line) (format "[%s]") (read-string))
        list-a (if (< (count list-1) (count list-2)) list-1 list-2)
        list-b (if (< (count list-1) (count list-2)) list-2 list-1)
        list-a-frequencies (frequencies list-a)
        list-b-frequencies (frequencies list-b)
        ]
    (->> list-b-frequencies
         (reduce-kv (partial get-missing-numbers list-a-frequencies) [])
         (sort)
         (clojure.string/join " ")
         (println)
         )
    )
  )

;;https://www.hackerrank.com/challenges/rotate-string/problem?isFullScreen=true

(defn rotate-string [input-string]
  (loop [rotated-strings []]
    (cond
      (empty? rotated-strings) (recur (conj rotated-strings (str (.substring input-string 1) (first input-string))))
      (= (count rotated-strings) (count input-string)) rotated-strings ;; we stop when we have done every possible rotations
      :else (let [latest-rotated-string (peek rotated-strings)]
              (recur (conj rotated-strings (str (.substring latest-rotated-string 1) (first latest-rotated-string))))
              )
      )
    )
  )

(doseq [_ (range (Integer/parseInt (read-line)))]
  (->> (read-line)
       (rotate-string)
       (clojure.string/join " ")
       (println))
  )

;;https://www.hackerrank.com/challenges/subset-sum/problem?isFullScreen=true

(defn subset-sum [a-vector, s-int]
  (loop [subset-size 0 a-seq a-vector, subset-val 0]
    (cond
      (<= s-int subset-val) subset-size
      (empty? a-seq) -1
      :else (recur (inc subset-size), (rest a-seq), (+' subset-val (first a-seq)))
      )
    )
  )
(let [_ (read-line)
      a-seq (->> (read-line) (format "[%s]") (read-string) (sort >))
      nb-test-cases (Integer/parseInt (read-line))]
  (doseq [_ (range nb-test-cases)]
    (->> (Integer/parseInt (read-line))
         (subset-sum a-seq,)
         (println))
    )
  )


;;https://www.hackerrank.com/challenges/captain-prime/problem?isFullScreen=true

(defn prime? [n-int]
  (if (<= n-int 1) false
                   (every? #(not (zero? (rem n-int %))) (range 2 (-> (Math/sqrt n-int) (int) (inc)))))
  )

(defn has-zero? [n-int]
  (some (partial = \0) (str n-int))
  )

(defn get-left-numbers
  "Take a positive integer and return the numbers that are obtained when the
  left digits are successively taken off,
  Ex: 4781 -> [781,81,1]
  "
  [n-int]
  (loop [left-numbers [], digits (rest (str n-int))]
    (cond
      (empty? digits) left-numbers
      :else (recur (conj left-numbers (->> (clojure.string/join digits) (Integer/parseInt))), (rest digits))
      )
    ))

(defn get-right-numbers
  "Take a positive integer and return the numbers that are obtained when the
right digits are successively taken off,
Ex: 4781 -> [478, 47, 4]
"
  [n-int]
  (loop [right-numbers [], n-inner-int (quot n-int 10)]
    (cond
      (zero? n-inner-int) right-numbers
      :else (recur (conj right-numbers n-inner-int), (quot n-inner-int 10))
      )
    )
  )

(defn left-prime? [n-int]
  (every? prime? (get-left-numbers n-int))
  )
(defn right-prime? [n-int]
  (every? prime? (get-right-numbers n-int))
  )
(doseq [_ (range (Integer/parseInt (read-line)))]
  (->> (read-line)
       (Integer/parseInt)
       ((fn [n-int] {:n-int n-int, :is-prime (prime? n-int)})) ;; check if a number is prime
       ;;check if the number has zero in its digits, do not do the computation if the number is not a prime
       ;; as the default value for a non existing key will be nil equivalent to false
       ((fn [{:keys [n-int is-prime] :as result}] (if (not is-prime) result (assoc result :no-zero (not (has-zero? n-int))))))
       ;; if the number is prime, check if its 'left numbers' are prime
       ((fn [{:keys [n-int, is-prime, no-zero] :as result}]
          (if (and is-prime no-zero) (assoc result :left (left-prime? n-int)) result)))
       ;; if the number is prime check if its right numbers are prime
       ((fn [{:keys [n-int, is-prime, no-zero] :as result}]
          (if (and is-prime no-zero) (assoc result :right (right-prime? n-int)) result)))
       ;; return the position of the number depending of the previous results
       ((fn [{:keys [is-prime, no-zero, left, right]}] (cond
                                                         (and is-prime, no-zero, left, right) "CENTRAL"
                                                         (and is-prime, no-zero, left) "LEFT"
                                                         (and is-prime, no-zero, right) "RIGHT"
                                                         :else "DEAD"
                                                         )))
       (println)
       )
  )

;;https://www.hackerrank.com/challenges/remove-duplicates/problem?isFullScreen=true

(->> (read-line)
     (distinct)
     (clojure.string/join)
     (println))


;;https://www.hackerrank.com/challenges/jumping-bunnies/problem?isFullScreen=true

(defn pgcd [a b]
  (if (zero? b) a (recur b (rem a b)))
  )



(defn ppcm [a b]
  ;; autopromote numbers with *'
  (quot (*' a b) (pgcd a b)))                               ;;https://stackoverflow.com/questions/8767627/how-do-i-avoid-arithmeticexception-integer-overflow-in-clojure

(defn read-vector! []
  (->> (read-line) (re-seq #"\w+") (map #(Integer/parseInt %)) (into []))
  )

(let [_ (read-line)
      js (read-vector!)]
  (->> js
       (reduce ppcm)
       (str)
       (println)
       )
  )

;;https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?isFullScreen

(defn plusMinus [arr]
  (let [n-int (count arr)
        nb-positives (count (filter pos? arr))
        nb-negatives (count (filter neg? arr))
        nb-zeros (count (filter zero? arr))

        ratios-elts (map #(/ (double %) n-int) [nb-positives, nb-negatives, nb-zeros])
        ]
    (doseq [elt ratios-elts] (println (format "%.6f" elt)))
    )
  )


(defn miniMaxSum [arr]
  (let [arr-sorted (sort arr)
        max-sum (reduce + 0 (rest arr-sorted))
        min-sum (reduce + 0 (drop-last arr-sorted))]
    (println min-sum max-sum)
    )
  )


(defn timeConversion [^String s]
  (let [time-parts-strings (re-seq #"\d+" s)
        hour-int (Integer/parseInt (first time-parts-strings))
        period-of-day (.substring s 8)
        ]
    (cond
      ;;special cases
      (and (= hour-int 12) (= period-of-day "AM")) (format "00%s" (.substring s 2 8))
      (and (= hour-int 12) (= period-of-day "PM")) (.substring s 0 8)
      (= period-of-day "AM") (.substring s 0 8)
      (= period-of-day "PM") (format "%2d%s" (+ 12 hour-int) (.substring s 2 8))
      )
    ))

(defn fizzBuzz [n]
  (doseq [i (range 1 (inc n))] (cond
                                 (zero? (mod i 15)) (println "FizzBuzz")
                                 (zero? (mod i 5)) (println "Buzz")
                                 (zero? (mod i 3)) (println "Fizz")
                                 :else (println i)
                                 ))

  )

(defn lonelyinteger [a]
  (->> (frequencies a)
       (filter #(= 1 (val %)))
       (first)
       (key)
       )
  )

;;https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem?isFullScreen=true
(defn diagonalDifference [arr]
  (let [diag1-sum (->> (for [i (range (count arr))] (get-in arr [i i]))
                       (reduce + 0)),
        diag2-sum (->> (for [i (range (count arr))] (get-in arr [i (- (dec (count arr)) i)]))
                       (reduce + 0))
        ]
    (Math/abs (- diag1-sum diag2-sum))
    )
  )


(defn countingSort [arr]
  (reduce (fn [frequency-arr, elt] (update-in frequency-arr [elt] inc)) (into [] (repeat 100 0)) arr)
  )

;;https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem?isFullScreen=true

(defn- column-ordered? [grid, column-number]
  (->> grid
       (map (fn [chars-seq] (nth chars-seq column-number)))
       (map int)                                            ;; have to convert
       (apply <=)
       )
  )
(defn gridChallenge
  "Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending.
  Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not"
  [grid-strings]
  (let [sorted-grid-seq-of-seq-of-char (for [s grid-strings] (into [] (sort s)))
        _ (println sorted-grid-seq-of-seq-of-char)
        string-length (count (first grid-strings))
        ] (if (every? (partial column-ordered? sorted-grid-seq-of-seq-of-char) (range string-length))
            "YES" "NO"))

  )

(defn repeat-string [n ^String s-string]
  (->> (repeat n s-string) (clojure.string/join)
       ))
(defn ^String super-digit [^String p-inner-string]
  "Given a number (as a string) sum the digits recursively until there is only one left"
  (if (= (count p-inner-string) 1) p-inner-string           ;; base case
                                   (->> p-inner-string
                                        (map (fn [x] (Character/getNumericValue x))) ;; transform the character into numbers
                                        (reduce +')         ;; sum them up
                                        (str)               ;; transform to string
                                        (recur)             ;; do a recursion in case the sum is greater than 9
                                        )))
(defn ^String superDigit [^String n-string k-int]
  (let [partial-super-digit (Integer/parseInt (super-digit n-string))
        partial-super-digit (*' k-int partial-super-digit)
        ]
    (super-digit (str partial-super-digit))
    )

  )


(defn minimumBribes [q-seq-of-ints]
  (loop [q-inner q-seq-of-ints, i-itr 1, nb-bribes 0]
    (cond
      (empty? q-inner) (println nb-bribes)
      (<= 0 (- (first q-inner) i-itr) 2) (recur (rest q-inner) (inc i-itr) (+ (- (first q-inner) i-itr) nb-bribes))
      (<= 3 (- (first q-inner) i-itr)) (println "Too chaotic")
      :else (recur (rest q-inner) (inc i-itr) nb-bribes)
      )
    )
  )

(def matching-brackets-map {\( \), \{ \}, \[ \]})
(defn matching-brackets [input-string]
  (loop [[current-char & remaining-chars :as input-inner-string] input-string, brackets-stack []]
    (cond
      (empty? input-inner-string) (empty? brackets-stack)
      (contains? #{\( \{ \[} current-char) (recur remaining-chars (conj brackets-stack (matching-brackets-map current-char)))
      (and (contains? #{\) \} \]} current-char) (= (peek brackets-stack) current-char)) (recur remaining-chars (pop brackets-stack))
      (contains? #{\) \} \]} current-char) false
      :else (recur remaining-chars brackets-stack)
      )
    )
  )

(defn isBalanced [input-string]
  (if (matching-brackets input-string) "YES" "NO")
  )

(defn parse-command [command-string]
  (let [tokens-seq (re-seq #"\w+" command-string)]
    (case (first tokens-seq)
      "1" {:operation :append, :param (second tokens-seq)}
      "2" {:operation :delete :param (Integer/parseInt (second tokens-seq))}
      "3" {:operation :print :param (Integer/parseInt (second tokens-seq))}
      "4" {:operation :undo}
      )
    )
  )

(defn read-command [{:keys [previous-content-strings, ^String content-string] :as editor-content-map}, command-map]
  (case (:operation command-map)
    :append {
             :previous-content-strings (conj previous-content-strings content-string),
             :content-string           (str content-string (:param command-map))
             }
    :delete {
             :previous-content-strings (conj previous-content-strings content-string),
             :content-string           (.substring content-string 0 (- (count content-string) (:param command-map)))
             }

    :print (do
             (println (.charAt content-string (dec (:param command-map))))
             editor-content-map
             )
    :undo {
           :previous-content-strings (pop previous-content-strings),
           :content-string           (peek previous-content-strings)
           }
    )
  )

(loop [i (Integer/parseInt (read-line)), editor-content-map {:content-string "", :previous-content-strings []}]
  (cond
    (zero? i) (:content-string editor-content-map)
    :else (recur (dec i) (read-command editor-content-map (-> (read-line) (parse-command))))
    )
  )

;;https://www.hackerrank.com/challenges/one-week-preparation-kit-jesse-and-cookies/problem?isFullScreen=true

(defn one? [n-int]
  (= n-int 1))
(defn cookies [^long k-int, A-vec-of-int]
  (loop [A-inner-vec-of-int A-vec-of-int, nb-ops-int 0]
    (cond
      (every? (partial <= k-int) A-inner-vec-of-int) nb-ops-int
      (and (one? (count A-inner-vec-of-int)) (< (first A-inner-vec-of-int) k-int)) -1
      :else (let [sorted-A (into [] (sort A-inner-vec-of-int))
                  least-sweet (first sorted-A)
                  second-least-sweet (second sorted-A)
                  sweeter-A (conj (subvec sorted-A 2) (+' least-sweet (*' 2 second-least-sweet)))
                  ]
              (recur sweeter-A (inc nb-ops-int))
              )
      )
    )

  )
