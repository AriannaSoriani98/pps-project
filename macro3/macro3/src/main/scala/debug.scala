import scala.compiletime.*

inline def debug1(inline expr: Any): Unit =
  println(codeOf(expr) + " = " + expr)

@main def testDebug1(): Unit = {
  val someVariable = 42
  // Classico debug
  println("someVariable = " + someVariable)
  // Debug con la macro
  debug1(someVariable)
}

@main def tryCodeOf():Unit =
  val x = 6
  val y = 7
  debug1(x * y) // Prints x.*(y) = 42



