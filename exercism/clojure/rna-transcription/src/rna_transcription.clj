(ns rna-transcription)

(defn- nucleotide->complement [nuc-char]
  (case nuc-char
    \G \C
    \C \G
    \T \A
    \A \U
    )
  )

(defn to-rna [dna]
  (if (every? (partial contains? #{\G \C \T \A}) dna)
    (->> dna (map nucleotide->complement) (clojure.string/join))
    (throw (AssertionError. "Wrong input."))
    )

  )
