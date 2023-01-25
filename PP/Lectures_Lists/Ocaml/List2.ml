(* /////////// Zadanie 5 ///////////////*)

let rec initSegment(segment, list) =
	match (segment, list) with
	  ([],_) -> true
	| (_,[]) -> false
	| (h_s::t_s,h::t) -> if h_s = h then initSegment(t_s, t) 
          else false;;


        initSegment([3;2],[1;2;3]);;


(* /////////// Zadanie 6 ///////////////*)

let rec replaceNth(list, index, element) = 
  match (list, index) with
  |([], _) -> []	
  |(head :: tail, 0) -> element :: tail
  |(head :: tail, _) -> head :: replaceNth(tail, index-1, element);;
      