type nucleotide = A | C | G | T

let hamming_distance dna1 dna2 =
  if List.length dna1 = List.length dna2 then
    Ok(List.fold_left (fun x y -> x + y) 0 (List.map2 (fun x y -> if x == y then 0 else 1) dna1 dna2))
  else if List.length dna1 = 0 then
    Error "left strand must not be empty"
  else if List.length dna2 = 0 then
    Error "right strand must not be empty"
  else
    Error "left and right strands must be of equal length"
    
