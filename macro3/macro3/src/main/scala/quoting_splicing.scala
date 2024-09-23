import scala.quoted.{Expr, Quotes}

class quoting_splicing {

  def example(using Quotes): Expr[Int] = '{
    val x = 3
    x + 1
  }

}

inline def addOne(x: Int): Int = ${ addOneImpl('x) }

def addOneImpl(x: Expr[Int])(using Quotes): Expr[Int] = '{
  $x + 1
}
