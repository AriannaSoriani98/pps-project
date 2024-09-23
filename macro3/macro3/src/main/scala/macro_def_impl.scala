import scala.quoted.{Expr, Quotes}

inline def assert(c:Boolean, inline m:String):Int=
  ${ code3('c, 'm) }

  
def code3(c:Expr[Boolean],m:Expr[String])(using Quotes): Expr[Int]= ???
