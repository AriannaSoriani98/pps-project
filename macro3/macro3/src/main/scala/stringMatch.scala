import scala.compiletime.*
import scala.quoted.*

object stringMatch:
  opaque type StringMatching[R <: String & Singleton] = String

  inline given string2StringMatching[S <: String & Singleton, R <: String & Singleton]:
    Conversion[S, StringMatching[R]] = str =>
      inline val regex = constValue[R]
      inline if matches(str, regex)
      then str.asInstanceOf[StringMatching[R]]
      else error(str + " does not match " + regex)

  inline def matches(inline str: String, inline regex: String): Boolean =
    ${ matchesImpl('str, 'regex) }

  def matchesImpl(str: Expr[String], regex: Expr[String])(
    using Quotes): Expr[Boolean] =
    Expr(str.valueOrAbort.matches(regex.valueOrAbort))



