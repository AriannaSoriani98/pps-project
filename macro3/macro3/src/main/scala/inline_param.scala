class inline_param {
  val x = 2
  def myCondition(): Boolean = x == 1

  inline def assert(inline cond: Boolean, inline msg: String): Unit =
    if !cond then throw new AssertionError(msg)

  assert(x == 1, "Expected x to be 1 but was " + x)

  if !(x==1) then
    throw new AssertionError("Expected x to be 1 but was " + x)

}
