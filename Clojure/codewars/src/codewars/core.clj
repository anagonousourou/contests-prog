(ns codewars.core
  (:require [clojure.spec.alpha :as s]))


(defn get-sum [a b]
  (let [
        small-number (min a b)
        big-number (max a b)
        nb-terms (inc (- big-number small-number))
        abs-small-number (Math/abs small-number)
        ]
    (cond
      (= a b) a
      (pos? small-number)  (-> (+ small-number big-number) (* nb-terms) (/ 2))
      (zero? small-number) (-> (inc big-number) (* big-number) (/ 2))
      (zero? big-number) (->  (inc abs-small-number) (* abs-small-number) (/ 2) (-) )
      (neg? (* small-number big-number)) (+ (get-sum 0 big-number) (get-sum small-number 0))
      (pos? (* small-number big-number)) (- (get-sum (Math/abs small-number) (Math/abs big-number)))
      )
      )
  )

(defn reverse-words [words]
  (->> (clojure.string/split words #"\s+")
       (reverse)
       (clojure.string/join " "))
  )

(defn seven-wonders-science
  "Count up the points for the 7 Wonders board game! Easy version"
  [compasses gears tablets]
  (let [step1 (-> (min compasses gears tablets)
                  (* 7))
        step2 (-> (* compasses compasses)
                  (+ (* gears gears))
                  (+ (* tablets tablets)))
        ]
    (+ step1 step2)
    )
  )

(defn- basic-decimal-to-roman-mapping [decimal-number]
  (case decimal-number
    1 "I"
    5 "V"
    10 "X"
    50 "L"
    100 "C"
    500 "D"
    1000 "M"
    )
  )

(defn- position [n]
  (cond
    (<= n 9) 10
    (<= 10 n 99) 100
    (<= 100 n 999) 1000
    ))
(defn solution [n]

  )

(def VOWELS #{\a \e \u \i \o })
(defn disemvowel
  [phrase]
  (->> phrase
      (filter (fn [x] (-> (contains? VOWELS (Character/toLowerCase x)) (not)) ))
       (reduce str)
       )
  )

(defn nb-year
  "In a small town the population is p0 = 1000 at the beginning of a year.
The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town.
How many years does the town need to see its population greater or equal to p = 1200 inhabitants?"
  [p0 percent aug target-population]
  (loop [current-pop p0, inc-factor (-> (/ percent 100) (+ 1)),  current-year 0]
    (if (>= current-pop target-population) current-year (recur (int (+ aug (* current-pop inc-factor)))  inc-factor (inc current-year)))
    )
  )

(defn- left-sum [arr]
  (loop [original-arr arr sum-arr [0]]
    (if (empty? original-arr)
      (subvec sum-arr 1)
      (recur (rest original-arr) (conj sum-arr (+ (last sum-arr) (first original-arr)))))
    )
  )

(defn find-even-index [arr]
  (let [
        left-sum-arr (left-sum arr) ;; compute a vector with the cumulative sum of the original vector
        last-index  (dec (count left-sum-arr))
        ]
    (loop [current-index 0]
      (if (> current-index last-index) -1 ;; stop the computation and return the default value
      (let [
            sum-of-left-side (nth left-sum-arr (dec current-index) 0)
            sum-of-right-side (if (= current-index last-index) 0 ;; if we are on  the last element then there is nothing at its right = 0
                                                               (- (nth left-sum-arr last-index 0) (nth left-sum-arr current-index 0))
                                                               )
            ]
        (if (= sum-of-left-side sum-of-right-side) current-index
                                                   (recur (inc current-index))

          )
        ))
     ))
  )

(defn find_shortest [words]
  (->> (clojure.string/split words #"\s")
       (map count)
       (apply min)
       )
  )

(def seconds-in-hour 3600)
(defn human-readable
  [nb-seconds]
  (let [nb-hours (int (/ nb-seconds seconds-in-hour))
        nb-seconds (- nb-seconds (* nb-hours seconds-in-hour))
        nb-minutes (int (/ nb-seconds 60))
        nb-seconds (- nb-seconds (* nb-minutes 60))
        ]
    (format "%02d:%02d:%02d" nb-hours nb-minutes nb-seconds))
  )


(defn encode-dups
  [text]
  (let [text (.toLowerCase text)
        char-frequencies (frequencies text)]
    (println char-frequencies)
    (->> text
        (map (fn [ch] (if (> (char-frequencies (Character/toLowerCase ch)) 1) ")" "(")))
         (reduce str)
         )
    )
  )

(defn get-prime-numbers-less-than
  "Find primes number up to (non-including) limit-integer"
  ([limit-integer]
   (let [positive-limit (Math/abs limit-integer)]
     (cond
       (<= positive-limit 2)  []
       :else (loop [current-integer 2 prime-numbers [2]]
               (cond
                 (>= current-integer positive-limit) prime-numbers ;; if we reached the
                 (not-every? (fn [n] (not= (mod current-integer n) 0)) prime-numbers) (recur (inc current-integer) prime-numbers)
                 :else (recur (inc current-integer) (conj prime-numbers current-integer)))))
     )

  ))

(defn find-prime-factors [numbers]
  (let [
        positive-numbers  (map #(Math/abs %) numbers)
        max-number (inc (reduce max 0 positive-numbers))
        prime-numbers (get-prime-numbers-less-than max-number )
        ]
    (->> numbers
         (map #(filter (fn [x] (zero? (mod % x))) prime-numbers) )
         (flatten)
         (set)
         (vec)
         (sort)
         )
    )
  )

(defn sum-of-divided [lst]
  (->> lst
       (find-prime-factors)
       (map (fn[prime-factor] [prime-factor, (->> lst
                                                  (filter #(zero? (mod % prime-factor)))
                                                  (reduce + 0)
                                                  ) ]))
       ))

(defn distinct-by
  "https://stackoverflow.com/questions/32998869/custom-equality-in-clojure-distinct"
  [f coll]
  (let [groups (group-by f coll)]
    (map #(first (groups %)) (distinct (map f coll)))))


(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!" (get-prime-numbers-less-than 20)))
