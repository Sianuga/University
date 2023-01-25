
  type 'a nlist = Koniec | Element of 'a * ('a nlist);;
  type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist);;



  let rec dzialanie listOne listTwo operator =
    match listOne, listTwo with
    | Koniec, Koniec -> []
    | Koniec, Element (elem, next) -> (operator elem 0)::(dzialanie Koniec next operator) 
    | Element (elem, next), Koniec -> (operator elem 0)::(dzialanie Koniec next operator) 
    | Element (elem, next), Element (elem2, next2) -> (operator elem elem2)::(dzialanie next next2 operator);;


    let nList1 = Element(1,Element(2,Element(3,Element(4,Koniec))));;
    
    let nList2 = Element(1,Element(2,Element(3,Koniec)));;

    dzialanie nList1 nList2 (+) ;;
    dzialanie nList1 nList2 (-) ;;
    dzialanie nList1 nList2 ( * ) ;;



  let rec toLazyList xs =
    match xs with
    [] -> LKoniec
    | h::t -> LElement(h, function () -> toLazyList t);;

let x = [1;2;3;4;5;6];;
let y = [0;2;4;6;8];;


let nlList1 = toLazyList x;;
let nlList2 = toLazyList y;;


let rec from_llist l =
  match l with
  | LKoniec -> []
  | LElement (x, f) -> x :: from_llist (f ())
  



    let rec ldzialanie listOne listTwo operator =
      match listOne, listTwo with
      | LKoniec, LKoniec -> LKoniec 
      | LKoniec, LElement (elem, next) -> LElement((operator elem 0),fun()->(ldzialanie LKoniec (next()) operator) )
      | LElement (elem, next), LKoniec -> LElement((operator elem 0),fun()->(ldzialanie LKoniec (next()) operator) )
      | LElement (elem, next), LElement (elem2, next2) ->
        LElement((operator elem elem2),fun()->(ldzialanie (next()) (next2()) operator) ) ;;

  from_llist (ldzialanie nlList1 nlList2 (+));;
  from_llist (ldzialanie nlList1 nlList2 (-)) ;;
  from_llist  (ldzialanie nlList1 nlList2 ( * )) ;;

 

      
let f x = x+1
let thunk = lazy (f);;

Lazy.force thunk(Lazy.force thunk 0);;
