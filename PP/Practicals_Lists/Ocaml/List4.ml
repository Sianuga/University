
(* /////// Zadanie 1 /////////////// *)

let f_l lists value =
  List.filter (fun list -> (List.fold_left (+) 0 list)==value) lists;;
  
  f_l [[1;2;3];[2;4];[5;6]] 6;;
  f_l [[];[];[]] 3;;
  f_l [[12;0;0];[-5;17];[6;6]] 12;;
  
  (* ////////////////////////////////// *)
  
  (* let isEqual valueCheck value  = if value==valueCheck then true else false;;
  
  let predicate = isEqual 6;;
  List.filter predicate [0;3;4;5;6];;
  
  (List.fold_left (+) 0 [1;2;3])==6;;
  
  let check = fun value -> (fun list -> (List.fold_left (+) 0 list)==value);;
  
  check 6 [1;2;3];; *)
  
  (* /////// Zadanie 2 /////////////// *)
  
  let rec f_d_aux decNum = 
    match decNum with
    | 0 -> []
    | _ -> List.append (f_d_aux (decNum/16)) [decNum mod 16] ;;

  let rec f_d decNum =
  if decNum==0 then [0] 
  else
    f_d_aux decNum;;
  

   f_d 31;;
   f_d 0;;
   f_d 1223213;;
   f_d (-1);;
  
  
  
  (* /////// Zadanie 3 /////////////// *)
  
  let rec f_k_aux acc list = 
    match list with 
    | [] -> acc
    | (a,b,c,d)::t -> f_k_aux (List.append acc [a^b^c^d]) t;;
  
  
  let f_k list =
    match list with
    | [] -> []
    | (a,b,c,d)::t -> f_k_aux [] list;;
  
    
    f_k [("ala","ma","kot","a");("kot","nie","ma","ali")];;
    f_k [];;
    f_k [("A","B","C","D");("A","B","C","D") ;("A","B","C","D") ];;

  
  
  (* ////////////////////////////////// *)
  