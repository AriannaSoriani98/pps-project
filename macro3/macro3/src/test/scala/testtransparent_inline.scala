import org.junit.Assert.assertTrue
import org.junit.Test

class testtransparent_inline:
  @Test def testType()=
    val instance = new transparent_inline()
    // Verifica i tipi
    assertTrue(instance.x1.isInstanceOf[Any])
    assertTrue(instance.x2.isInstanceOf[Any])
    assertTrue(instance.y1.isInstanceOf[Int])
    assertTrue(instance.y2.isInstanceOf[String])

  @Test def testDynamic()=
    val foo = new DynamicFoo()
    val a: Int = foo.a // Any narrowed to Int
    val b: Float = foo.b // Any narrowed to Float
    val c: String = foo.c // Any narrowed to String
    //val d = foo.d // COMPILE ERROR: no field named d
    assertTrue(foo.a.isInstanceOf[Int])
    assertTrue(foo.b.isInstanceOf[Float])
    assertTrue(foo.c.isInstanceOf[String])
