import scala.quoted.{Expr, Quotes, Type}

  
inline def timed[T](inline x:T) : (T,Long) = ${ code[T]('x)}

def code[T: Type](x: Expr[T])(using Quotes) = 
    '{
      val startTime = System.currentTimeMillis()
      val result:T = $x
      val endTime = System.currentTimeMillis()
      (result, endTime-startTime)
    }
  
