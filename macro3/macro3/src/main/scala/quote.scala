import scala.quoted.{Expr, Quotes}

def boolStr2(x:Expr[Boolean])(using Quotes): Expr[String] =
  x.value match
    case Some(true) => '{ "true" }
    case Some(false) => '{ "false" }
    case None => '{ $x.toString }

