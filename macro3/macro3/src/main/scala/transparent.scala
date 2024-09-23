class transparent {

  transparent inline def zero(inline tpe:String): Int | Long =
    if tpe == "Int" then 0
    else if tpe == "Long" then 0L
    else compiletime.error("No type checked")


  val a:Int = zero("Int")
  val b:Long = zero("Long")
 // zero("AnyVal") //err


}
