package math

import org.junit.Test
import java.lang.IllegalArgumentException

class PerimeterTest {
    @Test
    fun testPerimeterOfARectangle() = assert(perimeterOfARectangle(10.0, 5.0) == 30.0)

    @Test
    fun testPerimeterOfASquare() = assert(perimeterOfASquare(5.0) == 20.0)

    @Test
    fun testPerimeterOfACircle() = assert(perimeterOfACircle(1.0) == 2 *Math.PI)

    @Test
    fun testPerimeterOfATriangle() = assert(perimeterOfATriangle(5.0, 10.0, 10.0) == 25.0)

    @Test(expected = IllegalArgumentException::class)
    fun testPerimeterWithNegatives() {
        perimeterOfARectangle(-1.0, 0.0)
        perimeterOfASquare(-1.0)
        perimeterOfACircle(-1.0)
        perimeterOfATriangle(-1.0, 1.0, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testPerimeterWithZeros() {
        perimeterOfARectangle(0.0, 0.0)
        perimeterOfASquare(0.0)
        perimeterOfACircle(0.0)
        perimeterOfATriangle(0.0, 1.0, 1.0)
    }
}