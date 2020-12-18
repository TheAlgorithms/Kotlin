package dynamicProgramming

import junit.framework.Assert.assertEquals
import org.junit.Test

class FibonacciTest {
    private val n10: Int = 10
    private val n20: Int = 20
    private val n30: Int = 30
    private val n40: Int = 40

    private val Actual_10: Long = 55
    private val Actual_20: Long = 6_765
    private val Actual_30: Long = 832_040
    private val Actual_40: Long = 102_334_155


    @Test
    fun testFibonacci_recursion() {
        assertEquals(fibonacci_recursion(n10), Actual_10)
        assertEquals(fibonacci_recursion(n20), Actual_20)
        assertEquals(fibonacci_recursion(n30), Actual_30)
        assertEquals(fibonacci_recursion(n40), Actual_40)
    }

    @Test
    fun testFibonacci_DynamicProgramming() {
        assertEquals(fibonacci_dynamic(n10), Actual_10)
        assertEquals(fibonacci_dynamic(n20), Actual_20)
        assertEquals(fibonacci_dynamic(n30), Actual_30)
        assertEquals(fibonacci_dynamic(n40), Actual_40)
    }

    @Test
    fun testFibonacci_dynamic_optimized() {
        assertEquals(fibonacci_dynamic_optimized(n10), Actual_10)
        assertEquals(fibonacci_dynamic_optimized(n20), Actual_20)
        assertEquals(fibonacci_dynamic_optimized(n30), Actual_30)
        assertEquals(fibonacci_dynamic_optimized(n40), Actual_40)
    }

    @Test
    fun testFibonacci_matrix() {
        assertEquals(fibonacci_matrix(n10), Actual_10)
        assertEquals(fibonacci_matrix(n20), Actual_20)
        assertEquals(fibonacci_matrix(n30), Actual_30)
        assertEquals(fibonacci_matrix(n40), Actual_40)
    }

    @Test
    fun testFibonacci_matrix_optimized() {
        assertEquals(fibonacci_matrix_optimized(n10), Actual_10)
        assertEquals(fibonacci_matrix_optimized(n20), Actual_20)
        assertEquals(fibonacci_matrix_optimized(n30), Actual_30)
        assertEquals(fibonacci_matrix_optimized(n40), Actual_40)
    }

    @Test
    fun testFibonacci_formula() {
        assertEquals(fibonacci_formula(n10), Actual_10)
        assertEquals(fibonacci_formula(n20), Actual_20)
        assertEquals(fibonacci_formula(n30), Actual_30)
        assertEquals(fibonacci_formula(n40), Actual_40)
    }
}