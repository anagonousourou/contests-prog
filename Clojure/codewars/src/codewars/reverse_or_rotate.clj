(ns codewars.reverse-or-rotate
  (:import (java.util.regex Pattern)))

(defn- reverse-string? [string-chunk]
  (->> string-chunk
       (map (fn [x] (Character/getNumericValue x)))
       (map (fn[x] (* x x x)))
       (reduce + 0)
       ((fn [cube-sum] (mod cube-sum 2)))
       (zero?)
       ))
(defn- rotate-string [string-chunk]
  (str (.substring string-chunk 1) (.substring string-chunk 0 1))
  )

(defn- reverse-string [string-chunk]
  (->> string-chunk
      (reverse)
      (reduce str))
  )

(defn revrot [strng sz]
  (let [pattern-string (format "\\d{%d}" sz)
        pattern-obj (Pattern/compile pattern-string)

        ]
    (->> (re-seq pattern-obj strng)
         (map (fn[string-chunk] (if (reverse-string? string-chunk) (reverse-string string-chunk) (rotate-string string-chunk))))
         (reduce str)
         )
    )
  )