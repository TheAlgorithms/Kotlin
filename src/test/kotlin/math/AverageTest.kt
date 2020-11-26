package math

import org.junit.Test

class AverageTest {
    @Test
    fun testAverageArrayOfDouble() {
        val doubleArray = arrayOf(1.0, 1.25, 1.50, 1.75, 2.0)
        assert(average(doubleArray) == 1.50)
    }

    @Test
    fun testAverageArrayOfDoubleWithOneElement() {
        val doubleArray = arrayOf(1.0)
        assert(average(doubleArray) == 1.00)
    }

    @Test
    fun testAverageArrayOfInt() {
        val intArray = arrayOf(1, 2, 3)
        assert(average(intArray) == 2)
    }

    @Test
    fun testAverageArrayOfIntWithOneElement() {
        val intArray = arrayOf(1)
        assert(average(intArray) == 1)
    }
}