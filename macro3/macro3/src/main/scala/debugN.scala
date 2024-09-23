import scala.quoted.*

object debugN:

  inline def debugN(inline args: Any*): Unit = ${ debugNImpl('args) }

  private def debugNImpl(args: Expr[Seq[Any]])(using q: Quotes): Expr[Unit] =
    import q.reflect.*

    val exprs: Seq[Expr[String]] = args match
      case Varargs(es) =>
        es.map { e =>
          e.asTerm match
            case Literal(c: Constant) => Expr(c.value.toString)
            case _ => '{ ${ Expr(e.show) } + " = " + $e }
        }

    '{ println(${ exprs.reduce((e1, e2) => '{ $e1 + ", " + $e2 }) }) }
