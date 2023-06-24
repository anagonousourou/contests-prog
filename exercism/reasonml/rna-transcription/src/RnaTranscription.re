type dna =
  | A
  | C
  | G
  | T;

type rna =
  | A
  | C
  | G
  | U;

let toRna: list(dna) => list(rna) =
  (dnaSample: list(dna)) => {
    List.map(
      (nucleotide: dna) =>
        switch (nucleotide) {
        | G => C
        | C => G
        | A => U
        | T => A
        },
      dnaSample,
    );
  };
