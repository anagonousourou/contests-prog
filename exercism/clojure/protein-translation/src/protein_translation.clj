(ns protein-translation)

(defn translate-codon [codon] ;; <- arglist goes here
      (case codon
        "AUG" "Methionine"
        "UUU" "Phenylalanine"
        "UUC" "Phenylalanine"
        "UUG" "Leucine"
        "UUA" "Leucine"
        "UCU" "Serine"
        "UCC" "Serine"
        "UCA" "Serine"
        "UCG" "Serine"
        "UAU" "Tyrosine"
        "UAC" "Tyrosine"
        "UGU" "Cysteine"
        "UGC" "Cysteine"
        "UGG" "Tryptophan"
        "UAA" "STOP"
        "UAG"	"STOP"
        "UGA" "STOP"
        )
)

(defn translate-rna [] ;; <- arglist goes here
  ;; your code goes here
)
