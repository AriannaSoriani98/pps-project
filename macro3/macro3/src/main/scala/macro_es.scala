import scala.quoted.{Expr, Quotes}

inline def myMacro(inline x: Int): Int = ${ myMacroImpl('x) }

def myMacroImpl(xExpr: Expr[Int])(using Quotes): Expr[Int] = {
  // Estrazione del valore da Expr[Int] per manipolarlo
  val xValue = xExpr.valueOrAbort

  // Creazione di una nuova espressione usando lo splicing e il quoting
  '{ $xExpr + 10 }
}


