package math

import org.junit.Test
import java.lang.IllegalArgumentException

class AreaTest {
    @Test
    fun testAreaOfARectangle() = assert(areaOfARectangle(10.0, 5.0) == 50.0)

    @Test
    fun testAreaOfASquare() = assert(areaOfASquare(5.0) == 25.0)

    @Test
    fun testAreaOfACircle() = assert(areaOfACircle(1.0) == Math.PI)

    @Test
    fun testAreaOfATriangle() = assert(areaOfATriangle(5.0, 10.0) == 25.0)

    @Test(expected = IllegalArgumentException::class)
    fun testAreaWithNegatives() {
        areaOfARectangle(-1.0, 0.0)
        areaOfASquare(-1.0)
        areaOfACircle(-1.0)
        areaOfATriangle(-1.0, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testAreaWithZeros() {
        areaOfARectangle(0.0, 0.0)
        areaOfASquare(0.0)
        areaOfACircle(0.0)
        areaOfATriangle(0.0, 1.0)
    }
}