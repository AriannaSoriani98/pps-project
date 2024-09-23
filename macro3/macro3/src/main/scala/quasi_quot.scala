import scala.quoted.{Expr, Quotes}

object quasi_quot:
  val world = "world"
//  println(s"Hello $world!".structure)
//  println(s"Hello ${world}!")



def boolStr4(x: Expr[Int], expr: Expr[Int])(using Quotes): Expr[Int] =
    x.value match
      case Some(1) =>  '{val x = $expr; x}
      case _ => '{val x = ${expr}; x}

def code2(c:Expr[Int])(using Quotes): Expr[Int]= ???

inline def addTwo(x: Int): Int =  ${code2('x)}
inline def addThree(x: Int): Int = ${code2('{x})}

