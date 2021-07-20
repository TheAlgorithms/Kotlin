package dynamicProgramming

import org.junit.Test

internal class FibonacciTest {

    @Test
    fun testFibonacci1() {
        assert(fibonacci(0) == 0)
    }

    @Test
    fun testFibonacci2() {
        assert(fibonacci(1) == 1)
    }

    @Test
    fun testFibonacci3() {
        assert(fibonacci(4) == 3)
    }
}
