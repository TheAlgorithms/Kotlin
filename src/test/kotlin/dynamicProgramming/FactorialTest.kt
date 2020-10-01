package dynamicProgramming

import org.junit.Test

internal class FactorialTest {

    @Test
    fun testFactorial1() {
        assert(factorial(0) == 1)
    }

    @Test
    fun testFactorial2() {
        assert(factorial(1) == 1)
    }

    @Test
    fun testFactorial3() {
        assert(factorial(5) == 120)
    }
}
