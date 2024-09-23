import scala.quoted.*

def boolStr3(x: Expr[Boolean])(using Quotes): Expr[String] = {
  import quotes.reflect.report
  x.value match {
    case None =>
      report.error(
        "Expected a known value for x but got " + x.show, x
      )
      Expr("?")
    case Some(bool) => Expr(bool.toString)
  }
}

def useReflection(using Quotes): Unit = {
  import quotes.reflect.*
  val tree: Tree = ???  // Placeholder for a real Tree

  tree.show // Extension method

  tree match {
    case sel: Select => sel // TypeTest[Tree, Select]
    case Apply(fun, args) => Apply(fun, args)
  }
}

def fTree(x: Expr[Int])(using Quotes): Expr[Int] = {
  import quotes.reflect.*
  val tree: Term = x.asTerm

  val expr: Expr[Int] = tree.asExprOf[Int]

  expr
}

