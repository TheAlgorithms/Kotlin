package math

import org.junit.Test

class GCDTest {

    @Test
    fun testGCDofTwoNumbers() = assert(gcd(10, 20) == 10)

    @Test(expected = IllegalArgumentException::class)
    fun testErrorGCD() {
        gcd(-1, 0)
    }

    @Test
    fun testGCDofArray() {
        val array = arrayOf(20, 30, 40, 5, 50, 60, 10)
        assert(gcd(array) == 5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testErrorGCDArray() {
        gcd(arrayOf())
    }

}