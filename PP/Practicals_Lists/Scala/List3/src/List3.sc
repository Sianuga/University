
import scala.math._

def my_f1(f:(Double) => Double, number: Double):Double =
{
  return f(number);
}



my_f1(sqrt,2);
my_f1(expm1,5);
my_f1(abs,-52);



def sum(f:(Int)=>Int, sNum:Int,eNum: Int): Int =
{

  if(sNum==eNum) f(eNum);
  else
    {
      if(sNum>eNum)
        f(sNum) + sum(f, sNum-1, eNum)
      else
      f(sNum) + sum(f, sNum+1, eNum)
    }


}

def id(number:Int): Int = {number}

def cube(number:Int):Int = {number * number * number}

def fact(number:Int): Int = { if(number==0) 1
else
  number*fact(number-1)
}

sum(id,5,1)
sum(cube,1,3)
sum(fact,1,4)




sum((x:Int)=>x,1,5)
sum((x:Int)=>x*x*x,1,5)


