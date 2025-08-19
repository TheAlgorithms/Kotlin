package dataStructures

import org.junit.Test

class FibonacciTest {

    @Test
    fun testFibonacci1() {
        val num = 2L
        assert(fibonacci(num) == 1L)
    }

    @Test
    fun testFibonacci2() {
        val num = 20L
        assert(fibonacci(num) == 6765L)
    }

    @Test
    fun testFibonacci3() {
        val num = 50L
        assert(fibonacci(num) == 12586269025L)
    }
}