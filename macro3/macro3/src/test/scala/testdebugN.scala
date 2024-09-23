import org.junit.Test
import org.junit.Assert.assertEquals

class testdebugN:
  @Test def testDebugN() =
    import debugN._
    val x:Int = 10
    val y:Double = 20
    debugN("Test description", x, y, x * y)
    assertEquals(println("Test description, x = 10, y = 20.0, x.*(y) = 200.0"), debugN("Test description", x, y, x * y))

