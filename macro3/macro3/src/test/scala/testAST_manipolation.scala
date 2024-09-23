import org.junit.Assert.assertEquals
import org.junit.Test

class testAST_manipolation:
  @Test def DebugMacroTest() = {
    import ASTmanipol.*
    // Test case 1: Test with a simple integer
    val x = 42
    assertEquals(debug1(x),
      println("x: scala.Int = 42 "))

    // Test case 2: Test with a string expression
    val greeting = "Hello, world!"
    assertEquals(debug1(greeting),
      println("greeting: scala.String = Hello, world!"))

    // Test case 3: Test with a more complex expression
    val sum = x + 58
    assertEquals(debug1(sum),
      println("sum: scala.Int = 100"))

    // Test case 4: Test with a method call
    def square(n: Int): Int = n * n
    assertEquals(debug1(square(4)),
      println("square(4): scala.Int = 16"))

    // Test case 5: Test with a boolean expression
    val isPositive = x > 0
    assertEquals(debug1(isPositive),
      println("isPositive: scala.Boolean = true"))
  }


