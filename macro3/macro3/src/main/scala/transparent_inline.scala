import scala.quoted.*
import scala.language.dynamics

class transparent_inline {

  inline def foo(b: Boolean): Any =
    if b then 1 else "hello"

  val x1: Any = foo(true) // x1 == 1 but inferred type is declared Any
  val x2: Any = foo(false) // x2 == "hello" but inferred type is declared Any

  transparent inline def transFoo(b: Boolean): Any =
    if b then 1 else "hello"

  val y1: Int = transFoo(true) // x1 == 1 and inferred type narrowed to Int
  val y2: String = transFoo(false) // x2 == "hello" and inferred type is narrowed to String
}


class DynamicFoo extends Dynamic {
   transparent inline def selectDynamic(name: String): Any = ${ selectDynamicImpl('name) }
}

// must be public due to compiler bug
def selectDynamicImpl(name: Expr[String])(using q: Quotes): Expr[Any] = {
   import q.reflect.{*, given}
   name.valueOrAbort match
     case "a" => '{ 1: Int }
     case "b" => '{ 2.34f: Float }
     case "c" => '{ "hello": String }
     case n => report.errorAndAbort(s"no field named $n", name)
}


@main def tryTransparent() =
  val instance = new transparent_inline()
  // Stampa i valori di x1, x2, y1 e y2
  println(s"x1 (Any): ${instance.x1}, inferred type: ${instance.x1.getClass.getSimpleName}") // Should be 1
  println(s"x2 (Any): ${instance.x2}, inferred type: ${instance.x2.getClass.getSimpleName}") // Should be "hello"
  println(s"y1 (Int): ${instance.y1}, inferred type: ${instance.y1.getClass.getSimpleName}") // Should be 1
  println(s"y2 (String): ${instance.y2}, inferred type: ${instance.y2.getClass.getSimpleName}") // Should be "hello"





