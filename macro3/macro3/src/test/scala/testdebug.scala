import org.junit.Assert.assertEquals
import org.junit.Test

class testdebug:
  @Test def TestDebug() =
    val someVariable = 42

    assertEquals(
      // Prima linea di codice
      println("someVariable = " + someVariable),

      // Seconda linea di codice con la macro
      debug1(someVariable)
    )
