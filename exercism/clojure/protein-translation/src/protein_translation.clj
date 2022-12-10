(ns protein-translation)

(defn translate-codon [codon] 
      (case codon
        "AUG" "Methionine"
        "UUU" "Phenylalanine"
        "UUC" "Phenylalanine"
        "UUA" "Leucine"
        "UUG" "Leucine"
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
        "UAG" "STOP"
        "UGA" "STOP"
        )
)

(defn translate-rna 
  [rna]
  (->> rna
       (re-seq #"[A-Z]{3}")
       (take-while (fn [codon] (not (contains? #{"UAA" "UAG" "UGA"} codon))))
       (map translate-codon)
   )
  
)
