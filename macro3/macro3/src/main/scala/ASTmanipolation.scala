import scala.quoted.*

object ASTmanipol:

  inline def debug1[T](inline arg: T): Unit = ${debug1Impl('arg)}

  private def debug1Impl[T : Type](arg: Expr[T])(using Quotes): Expr[Unit] =
  '{println(${Expr(arg.show)} + ": " + ${Expr(Type.show[T])} + " = " + $arg)}

