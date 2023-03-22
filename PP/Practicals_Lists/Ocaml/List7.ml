

   let rec insertAuxDesc list elem =
    match list with
    |[]->[]
    |h::t when h>=elem-> h::elem::t 
    | h::t -> insertAuxDesc t elem ;;


  let rec insertAuxAsc list elem =
  match list with
  |[]->[]
  |h::t when h<=elem-> h::elem::t 
  | h::t -> insertAuxAsc t elem ;;

  
let rec insert list elem =
  match list with 
  | [] -> [elem]
  | h::t -> 
  (match t with
    | [] -> if h<=elem then h::elem::[]
    else elem::h::[]
    |head::tail -> 
      if ((h<=elem  &&  elem<=head)|| (h>=elem && elem>=head) )then
      h::elem::head::tail
      else
     h::( insert t elem)
    );; 

    let rec insert list elem =
      match list with 
      | [] -> [elem]
      | h::t -> 
        if elem < h then elem::h::t
        else if (h<=elem  ||  elem<=h) && (h>=elem || elem>=h) then
          h::elem::t
        else
          h::( insert t elem);;

  insert [1;3;5;7] (-4);;
    insert [] 1;;
    insert [1] 0;;
    insert [1] 2;;




       
       type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist);;

  let rec toLazyList xs =
    match xs with
    [] -> LKoniec
    | h::t -> LElement(h, function () -> toLazyList t);;

    let rec from_llist l =
      match l with
      | LKoniec -> []
      | LElement (x, f) -> x :: from_llist (f ())
   

       (* let lpowiel l =
        let rec pom l acc =
          match l with
          | LKoniec -> acc
          | LElement (hd, tl) ->
             let rec powiel hd acc =
               if hd > 0 then powiel (hd - 1) (LElement (hd, fun () -> acc)) else acc
             in
             pom (tl ()) (powiel hd acc)
        in
        pom l LKoniec;; *)


        (* let rec lpowiel lst =
          match lst with
          | LKoniec -> LKoniec
          | LElement (hd, tl) -> LElement (hd, fun () -> lpowiel (tl()));; *)


          let rec lpowiel lista =
            match lista with
            | LKoniec -> LKoniec
            | LElement(x, xs) -> 
                let rec repeat lista n =
                  if n = 0 then LKoniec
                  else LElement(x, fun () -> repeat lista (n-1))
                in
                let rec join list1 list2 =
                  match list1 with
                  | LKoniec -> list2
                  | LElement(x, xs) -> LElement(x, fun () -> join (xs()) list2)
                in
                  join (repeat lista x) (lpowiel (xs()))
          ;;
             


     from_llist(  lpowiel (toLazyList [1;2;3]));;
     from_llist(  lpowiel (toLazyList [0]));;

     let rec init n f =
      match n with
      |0 -> []
      | n when n<0 -> failwith("Negative number")
      |_ -> (f (n-1)) :: init (n-1) f;;

      let rec powiel lst =
        match lst with
        | [] -> []
        | hd::tl -> (init hd (fun _ -> hd)) @ (powiel tl);;

      powiel [1;2;3];;
      powiel [0];;



let rec fib number acc last =
  match number with 
  | 1 -> acc
  | _ -> fib (number-1) (acc+last) acc;;

