class inline {
  
  val x=2
  def myCondition(): Boolean = x==1
  
  inline def assert(cond:Boolean, msg: =>String):Unit = 
    if !cond then throw new AssertionError(msg)
    
  assert(x==1, "Expected x to be 1 but was "+x)
  
  val cond = myCondition()
  def msg = "Expected x to be 1 but was "+x
  
  if !cond then throw new AssertionError(msg)

}
