(* Ex 1*)


let rec flatten list =
  match list with 
  | [] -> []
  | h::t -> h@flatten t;; 
flatten [[1;2;3];[4;5];[6;7;8]];; 

(*Ex 2*)

let rec count element list = 
  match list with 
  | [] -> 0
  | h::t ->
    if h=element then 1 +count element t
    else count element t;; 


    count "a" ["a";"l";"a"];;

(*Ex 3*)

let rec replicate x n = 
  match n with
  | 0 -> []
  | _ -> x::replicate x (n-1);;


  replicate "A" 3;;

(*Ex 4*)

(* let rec sqrList list = 
  match list with
  | [] -> []
  | h::t -> h*h :: sqrList t;;

  sqrList [7;3;5];; *)
(*Ex 5*)

let rec reverse list =
  match list with
  | [] -> []
  | h::t -> reverse t @ [h] ;;

  reverse [1;2;3];;
(*Ex 6*)
(*Ex 7*)

let match_1 l =
  match l with [_; _; x; _; _] -> x
;;

let match_2_help t =
  match t with (x, y) -> x
;;

let match_2 l =
  match l with h::h2::t -> 
    match h2 with (x,y) -> x
;;

match_1 [-2; -1; 0; 1; 2];;
match_2 [(1, 2); (0, 1)];;

let [_;_;x;_;_] =  [-2; -1; 0; 1; 2];;
let [(_,_);(x,_)] = [(1, 2); (0, 1)];;