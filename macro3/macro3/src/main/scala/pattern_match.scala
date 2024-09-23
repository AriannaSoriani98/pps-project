import scala.quoted.{Expr, Quotes, Type}

class pattern_match {

  def f(expr: Expr[Option[Any]])(using Quotes) =
    expr match
      case '{ None } => ???
      case '{ Some($x) } => x:Expr[Any]
      case _ => ???

}

def f2[T:Type](expr: Expr[Option[Any]])(using Quotes) =
  expr match
    case '{ Some($n:Int) } => n:Expr[Int]
    case '{ Some($x: T) } => x:Expr[T]
    case '{ Some($y: t) } => y:Expr[t] //given Type[t] is made available



