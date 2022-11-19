package math

import math.getFactorial
import org.junit.Test
import java.security.InvalidParameterException

class FactorialTest {

    @Test
    fun testFactorialNormal() {
        val input = 6L
        val expectedFactorial = 720L
        assert(getFactorial(input) == expectedFactorial)
    }

    @Test(expected = InvalidParameterException::class)
    fun testFactorialOfNegativeNumber() {
        val input = -1L
        getFactorial(input)
    }

    @Test
    fun testFactorialOfZero() {
        val input = 0L
        val expectedFactorial = 1L
        assert(getFactorial(input) == expectedFactorial)
    }

    @Test
    fun testFactorialOfHighValue() {
        val input = 20000L
        val expectedFactorial = 0L
        assert(getFactorial(input) == expectedFactorial)
    }

}