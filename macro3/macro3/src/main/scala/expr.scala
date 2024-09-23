import scala.quoted.{Expr, Quotes}

def boolStr(x:Expr[Boolean])(using Quotes): Expr[String] =
  x.value match
    case None =>
      Expr("?")
    case Some(bool) =>
      Expr(bool.toString)


