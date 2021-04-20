package math

import math.median
import org.junit.Test

class Median {
    @Test
    fun testMedianWithEvenSize() {
        val array = intArrayOf(1, 2, 3, 4)
        assert(median(array) == 2.5)
    }

    @Test
    fun testMedianWithOddSize() {
        val array = intArrayOf(1, 2, 3)
        assert(median(array) == 2.0)
    }

    @Test
    fun testMedianWithNegatives() {
        val array = intArrayOf( 2, 3, 4, -2, -8, -3)
        assert(median(array) == 0.0)
    }
}
