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
  
(* https://www.codewars.com/kata/59daf400beec9780a9000045/train/ocaml *)

(* return whether needle is a subsequence of haystack *)
let rec is_subsequence (haystack : string) (needle : string) : bool =
  if String.empty = needle then
    true
  else if String.empty = haystack && String.empty != needle then
    false
  else if  String.lowercase_ascii (String.sub haystack 0 1) = String.lowercase_ascii (String.sub needle 0 1) then
    is_subsequence (String.sub haystack 1 ((String.length haystack) - 1)) (String.sub needle 1 ((String.length needle) - 1))
  else
    is_subsequence (String.sub haystack 1 ((String.length haystack) - 1)) needle

(* https://www.codewars.com/kata/52756e5ad454534f220001ef *)

let lcs (s1: 'a list) (s2: 'a list) = []
  (* Your code here *)
  
(* https://www.codewars.com/kata/5616868c81a0f281e500005c/train/ocaml *)

type participant = {
  firstname: string;
  winningNumber : int;
  weight : int;
}
(* https://batsov.com/articles/2022/10/24/ocaml-tips-converting-a-string-to-a-list-of-characters/ *)


let explode_string s = List.init (String.length s) (String.get s);;
let computeWinningNumber name = 
  (String.length name) + ((List.map (fun x -> (Char.code x) - (Char.code 'a') + 1) (explode_string (String.lowercase_ascii name))) |> List.fold_left ( + ) 0)

let rank (st: string) (we: int array) (n: int): string =
  let names = (String.split_on_char ',' st) in
  let nbParticipants = List.length names in
    if st = String.empty then
      "No participants"
    else if n > nbParticipants then
      "Not enough participants"
    else
      let selected_participant = List.map2 (fun name weight -> {
          firstname = name;
          winningNumber = (computeWinningNumber name) * weight;
          weight = weight;
        }) names (Array.to_list (Array.sub we 0 nbParticipants))
        |> List.sort (fun p1 p2 -> if (compare p1.winningNumber p2.winningNumber) = 0 then compare p1.firstname p2.firstname else -(compare p1.winningNumber p2.winningNumber)) in
        (List.nth selected_participant (n - 1)).firstname


(* https://www.codewars.com/kata/5552101f47fc5178b1000050/ocaml *)
let rec pow a = function
        | 0 -> 1
        | 1 -> a
        | n -> 
          let b = pow a (n / 2) in
          b * b * (if n mod 2 = 0 then 1 else a)

let dig_pow (n: int) (p: int): int =
  let nstr = string_of_int n in
  let digits = (explode_string nstr) |> List.map (fun x -> (int_of_char x) - (int_of_char '0')) in
  let powers = List.init (String.length nstr) (fun x -> x + p) in 
  let digitsum = List.map2 (fun x y -> pow x y ) digits powers |> List.fold_left ( + ) 0 in
  if digitsum mod n = 0 then digitsum / n else -1


(* https://www.codewars.com/kata/55a29405bc7d2efaff00007c/train/ocaml *)

(* this first version gives the wrong answer for n >= 23 because of an integer overflow *)

let rec factorial_inner result n  = 
  if n <= 1 then result else factorial_inner (result * n)  ( n - 1 ) 

let factorial = factorial_inner 1 

let rec going_inner result counter currentfact = 
  if currentfact <= 1 then
    result +. 1.
  else 
    going_inner (result +. (1. /. float_of_int(currentfact))) (succ counter) (currentfact / (succ counter))


let going (n: int) =
  let nfact = factorial n in
  going_inner 0.0 1 nfact


(* second version *)

let rec going_inner result counter current = 
  if counter = 1 then
    result +. 1.
  else 
    going_inner (result +. (current /. (float_of_int counter))) (pred counter) (current /. (float_of_int counter) )


let going (n: int) =
  going_inner 0. n 1.

let () = print_endline "Hello, World!"
