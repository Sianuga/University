 let f1 x = x 2 2;;
 f1 (fun (x)-> (fun(y)-> x+y)) 



 
 let f2 x y z = x ( y ^ z );;

 f2 (fun (x)->(fun (y)->x(y)))

 let f3 (x,y) = x+y;;

let a = f3(0,2)

 let f4 x y = x+y;;

 let rec f x = f x;;

 f 0;;

 let rec quicksort = function
 |[] -> []
 | [x] -> [x]
 | xs -> let small = List.filter (fun y -> y < List.hd xs ) xs
 and large = List.filter (fun y -> y >= List.hd xs ) xs
 in quicksort small @ quicksort large;;

 let rec quicksort' = function
 |[] -> []
 | x::xs -> let small = List.filter (fun y -> y < x ) xs
 and large = List.filter (fun y -> y > x ) xs
 in quicksort' small @ (x :: quicksort' large);;


 quicksort [0,1,7,214,3,15,127];;
 quicksort' [42,1,7,214,3,15,127];;


(* /////////// Zadanie 2 ///////////////*)

 let curry3 f x y z = f(x, y, z);;

(* curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd *)

let uncurry3 f (x, y, z) = f x y z

(* uncurry3 : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd *)

(* /////////// Zadanie 3 ///////////////*)

let sumProd list = List.fold_left (fun (s, p) h -> (s + h, p * h)) (0, 1) list;;
