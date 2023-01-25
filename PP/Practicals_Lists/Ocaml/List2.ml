

let rec fact_math number =
  match number with 
  | 0 | 1 -> (1,"Correct")
  | number when number>=2 -> (number*(fact_math(number-1)),"Correct")
  | _ -> (0,"Incorrect input")


  fact_math(-3);;
  fact_math(0);;
  fact_math(3);;
  fact_math(10);;
  fact_math(1);;




let rec natrzy_tail list_tail (list_1, list_2, list_3) =
  match list_tail with 
  | [] -> (list_1, list_2, list_3)
  | h::t -> match h with 
  | h when h mod 10 == 0 -> natrzy_tail t (h::list_1,h::list_2,list_3) 
  | h when h mod 5 == 0 -> natrzy_tail t (list_1, h::list_2, list_3)
  | h -> natrzy_tail t (list_1,list_2, h::list_3 ) ;;


let rec reverseAux accumulation list = 
  match list with
  | [] -> accumulation
  | h::t -> reverseAux (h::accumulation) t;;

  let reverse list =
    reverseAux [] list;;


let natrzy list =
 match list with
 | [] ->  [],[],[] 
 | _ -> natrzy_tail (reverse list) ([], [], []);;
         


  natrzy [1;10;15;25;30;40;7;18;5];;
  natrzy [1];;
  natrzy [];;
  natrzy [1;10;15];;
  natrzy [1;-2;-10;10];;


  let kak k =
    match k with 
    | 1 -> 2
    | _ -> 3;;

  let aaa h = 
    
  match h with 
  | h mod 10 == 0 -> 1
  | h mod 5 == 0 -> 5
  | _ -> kak h;;

  aaa 3;;