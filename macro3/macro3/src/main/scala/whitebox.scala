import scala.quoted.*


class WrappedInOption[T] {
  type Out
}

transparent inline given wrapInOption[T]: WrappedInOption[T] = ${ wrapInOptionImpl[T] }

private def wrapInOptionImpl[T: Type](using q: Quotes): Expr[WrappedInOption[T]] =
  '{ new WrappedInOption[T].asInstanceOf[WrappedInOption[T] {type Out = Option[T]}] }


