

def curry3[A,B,C,D](f: (A,B,C)=>D) =
  (x:A) => (y:B) => (z:C) => f(x,y,z)

def curry3[A,B,C,D](f:(A,B,C)=>D)(x:A)(y:B)(z:C) = f(x,y,z)

/*curry3: [A, B, C, D](f: (A, B, C) => D) = A => (B => (C => D))*/


def uncurry3[A,B,C,D](f: A=>B=>C=>D) =
  (x:A, y:B, z:C) => f(x)(y)(z)

def uncurry3[A,B,C,D]=(f:A=>B=>C=>D)=>(x:A,y:B,z:C)=>f(x)(y)(z)

/*uncurry3: [A, B, C, D](f: A => (B => (C => D)))(A, B, C) => D*/

def initSegment[A](segment:List[A], list:List[A]):Boolean =
  (segment, list) match {
    case (Nil, _) => true
    case (_, Nil) => false
    case _ =>
      if (segment.head == list.head) initSegment(segment.tail, list.tail)
      else false
  }



def sumProd(list:List[Int]) = (list foldLeft (0,1)) ((acc, h) => (acc._1 + h, acc._2 * h))

/*a) Ponieważ w momencie gdy lista ma więcej niż jeden element i nie ma mniejszych elementów niż pierwszy,
przestanie ona się dzielić i funkcja będzie się ciągle wywoływać rekurencyjnie dla tej samej listy, aż nastąpi stack overflow.
b) Jeśli jakiś element się powtarza, to w liście wynikowej będzie występował tylko raz.*/
