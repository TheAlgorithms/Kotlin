package mathematics

import org.junit.Test
import java.security.InvalidParameterException

class FactorialTest {

    @Test
    fun testFactorialNormal() {
        val input = 6
        val expectedFactorial = 720
        assert(getFactorial(input) == expectedFactorial)
    }

    @Test(expected = InvalidParameterException::class)
    fun testFactorialOfNegativeNumber() {
        val input = -1
        getFactorial(input)
    }

    @Test
    fun testFactorialOfZero() {
        val input = 0
        val expectedFactorial = 1
        assert(getFactorial(input) == expectedFactorial)
    }

}