(ns triangle)

(defn is-valid? [a b c]
  (cond 
    (not-every? (fn [n] (> n 0)) [a b c] ) false
    (< (+ a b) c) false
    (< (+ a c) b) false
    (< (+ b c) a) false
    :else true 
    )
  )

(defn equilateral? [a b c]
  (and (is-valid? a b c) (= a b c))
)

(defn isosceles? [a b c]
  (and (is-valid? a b c) (>= 2 (count (set [a b c]))))
)

(defn scalene? [a b c]
  (if (is-valid? a b c) (not (isosceles? a b c)) false)
)
