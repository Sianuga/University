let rec operateOnLastTwo list operator =
  match list with
| [] -> failwith "Not enough elements on stack"
| [x;y] -> operator(y,x)
| h::t -> operateOnLastTwo t operator;;

operateOnLastTwo [1;2;3] (fun(x,y)->x+y);;

let rec truncateLastTwo list = 
  match list with
  | [] | [_] -> failwith "Not enough elements on stack"
  | [x;y] -> []
  | h::t -> h::(truncateLastTwo t);;

  truncateLastTwo [1;2;3];;

(* let rec eval_aux listEval stack result =
  match listEval with
  | [] -> result
  | number::t -> eval_aux t (stack::number) result 
  | ((Add|Sub|Mul|Div) as operation)::t -> (
    match operation with
    | Add -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x+y))
    | Sub -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x-y))
    | Mul -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x*y))
    | Div -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)-> if y!=0 then x/y else failwith "Division by 0")) )  
  ;; *)



type eval = Num of float | Add | Sub | Mul | Div ;;




  let rec eval_aux listEval stack result =
    match listEval with 
    | [] -> result
    | (Num number)::t -> number +. (eval_aux t stack result) 
    | ((Add|Sub|Mul|Div) as operation)::t -> (
      match operation with
      | Add -> 1.
      | Sub -> 2.
      | Mul -> 3. +. (eval_aux t stack result) 
      | Div -> 4.
      | _ -> -1. );;


let rec eval list = 
  eval_aux list [] 1.;;

  eval [Mul;Num 5. ] ;;


  (* | ((Add|Sub|Mul|Div) as operation)::t -> 
    match operation with
    | Add -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x+y))
    | Sub -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x-y))
    | Mul -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)->x*y))
    | Div -> eval_aux t (truncateLastTwo stack) (operateOnLastTwo stack (fun(x,y)-> if y!=0 then x/y else failwith "Division by 0"))  ;;  *)



    let rec operateOnLastTwo list operator =
      match list with
    | [] -> failwith "Not enough elements on stack"
    | [x;y] -> operator(x,y)
    | h::t -> operateOnLastTwo t operator;;
    
    let rec truncateLastTwo list = 
      match list with
      | [] | [_] -> failwith "Not enough elements on stack"
      | [x;y] -> []
      | h::t -> h::(truncateLastTwo t);;


    type eval = Num of float | Add | Sub | Mul | Div ;;




    let rec eval_aux listEval stack result =
      match listEval with 
      | [] -> (
        match stack with
        | [] -> result
        | [x] -> if x==result then result else failwith "Stack is not empty" 
        | _ -> failwith "Stack is not empty"
      ) 
      | (Num number)::t -> eval_aux t (number::stack) result
      | ((Add|Sub|Mul|Div) as operation)::t -> (
        match operation with
        | Add -> let calculatedValue = (operateOnLastTwo stack (fun(x,y)->x+.y)) in
          eval_aux t (calculatedValue::(truncateLastTwo stack)) calculatedValue
        | Sub -> let calculatedValue = (operateOnLastTwo stack (fun(x,y)->y-.x)) in
        eval_aux t (calculatedValue::(truncateLastTwo stack)) calculatedValue
        | Mul -> let calculatedValue = (operateOnLastTwo stack (fun(x,y)->x*.y)) in
        eval_aux t (calculatedValue::(truncateLastTwo stack)) calculatedValue
        | Div -> let calculatedValue = (operateOnLastTwo stack (fun(x,y)-> if x==0. then failwith "Division by 0" else y/.x)) in
        eval_aux t (calculatedValue::(truncateLastTwo stack)) calculatedValue
        | _ -> eval_aux t stack result
        );;
  

let rec eval list = 
  eval_aux list [] 0.;;

  eval [Num 5.; Num 3.; Add; Num 2.; Add] ;;
 eval [Num 5.; Num 3.; Add; Num 2.; Add; Num 10.; Mul; Num 1.; Sub; Num 33.; Div ] ;; (* ((10*10)-1)/33 *)
  eval [];;
  eval [Num 5.; Num 3.; Add; Num 3.];;