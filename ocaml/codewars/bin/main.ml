(* https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/ocaml *)
let abbrev_name (name: string): string =
  List.map (fun word -> String.uppercase_ascii(String.sub word 0 1)) (String.split_on_char ' ' name)
  |> String.concat "."


(* https://www.codewars.com/kata/59342039eb450e39970000a6/train/ocaml *)
let odd_count (n: int): int =
    n / 2

(* https://www.codewars.com/kata/5b853229cfde412a470000d0/train/ocaml
       dad + x = 2 * (son + x)
       dad + x = 2* son + 2x
       -x = -dad + 2 * son
       *)
let twice_as_old dad son = 
    abs (-dad + 2 * son)


(* https://www.codewars.com/kata/62ad72443809a4006998218a/train/ocaml *)    
type like = Like | Dislike

let rules current_state action = 
  match current_state, action with
    |(Some(Like), Like) -> None 
    |(Some(Like), Dislike) -> Some(Dislike)
    |(Some(Dislike), Like) -> Some(Like)
    |(Some(Dislike), Dislike) -> None
    |(None, Like) -> Some(Like)
    |(None, Dislike) -> Some(Dislike)

let like_or_dislike (inputs: like list): like option =
  List.fold_left rules None inputs


(* https://www.codewars.com/kata/563e320cee5dddcf77000158/train/ocaml *)
let get_average lst =
  (List.fold_left (fun x y -> x + y) 0 lst) / (List.length lst)

(* https://www.codewars.com/kata/5556282156230d0e5e000089/train/ocaml *)
let dna_to_rna str =
  String.map (fun x -> if x = 'T' then 'U' else x) str

(* https://www.codewars.com/kata/555086d53eac039a2a000083/ocaml *)
let lovefunc (flower1: int) (flower2: int): bool =
    ((flower1 + flower2) mod 2) = 1

(* https://www.codewars.com/kata/57f780909f7e8e3183000078/ocaml *)
let grow (xs: int list): int =
  List.fold_left (fun x y -> x * y) 1 xs

(* https://www.codewars.com/kata/58261acb22be6e2ed800003a/train/ocaml *)
let get_volume_of_cuboid (length: int) (width: int) (height: int): int =
    length * width * height

(* https://www.codewars.com/kata/55d24f55d7dd296eb9000030/train/ocaml *)
let summation (n: int): int =
    ((1 + n) * n) / 2

(**)
let contains s1 s2 =
  try
    let len = String.length s2 in
      for i = 0 to String.length s1 - len do
        if String.sub s1 i len = s2 then raise Exit
      done;
      false
  with Exit -> true

let inArray(a1: string list) (a2: string list): string list =
    List.filter (fun x -> List.exists (fun word -> contains word x) a2) a1
    |> List.sort_uniq compare

(* https://www.codewars.com/kata/56484848ba95170a8000004d/train/ocaml  *)

let rec distances l = 
  match l with
    | [] -> []
    | first :: second :: t -> (second -. first) :: distances(second :: t)
    | _ -> []

let gps (s: int) (l: float list): int = 
  distances l |>
  List.map (fun x -> (3600. *. x) /. (float_of_int s)) |>
  List.fold_left max 0.0 |>
  int_of_float

  (*
  156 0 []
  1
  [0..fix_part] + 

     *)
(* https://www.codewars.com/kata/56a4872cbb65f3a610000026/train/ocaml *)
let rec rotations str fixed_part_length result = 
  if (String.length str) <= 1 then
    [str]
  else if result = [] then
    rotations str fixed_part_length [str]
  else if fixed_part_length >= (String.length str) - 1 then
    result
  else 
    let rotated = (String.sub str 0 fixed_part_length) ^ (String.sub str (1 + fixed_part_length) ((String.length str) - fixed_part_length - 1)) ^ (String.sub str fixed_part_length 1) in
    rotations rotated (fixed_part_length + 1) (rotated :: result)

let max_rot (n: int): int =
  rotations (string_of_int n) 0 [] |>
  List.map int_of_string |>
  List.fold_left max 0



(* https://www.codewars.com/kata/5b39e91ee7a2c103300018b3/train/ocaml *)
let rec nodups l = 
  match l with
  | [] -> []
  | first :: second :: tail -> if first = second then nodups (second :: tail) else first :: nodups(second :: tail)
  | x -> x

let remove_consecutive_duplicates (str : string) : string =
    String.split_on_char  ' ' str |> nodups |> String.concat " "
  

let () = print_endline "Hello, World!"
