(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (and (every? (partial contains? #{\A, \T , \C , \G }) strand)
           (contains? #{\A, \T , \C , \G } nucleotide))
    (->> strand (filter (partial = nucleotide)) (count))
    (throw (IllegalArgumentException.))
    )

)


(defn nucleotide-counts [strand]
  {
   \A (count-of-nucleotide-in-strand \A strand),
   \T (count-of-nucleotide-in-strand \T strand),
   \G (count-of-nucleotide-in-strand \G strand),
   \C (count-of-nucleotide-in-strand \C strand)
   }
)
