package math

import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * Calculate the area of a rectangle
 *
 * @param length length of rectangle
 * @param width width of rectangle
 * @return area of given rectangle
 */
fun areaOfARectangle(length: Double, width: Double) =  when {
    length > 0 && width > 0 -> length * width
    else -> throw IllegalArgumentException("Length and Width must be positive")
}

/**
 * Calculate the area of a square
 *
 * @param sideLength side length of square
 * @return area of given square
 */
fun areaOfASquare(sideLength: Double) =
    when {
        sideLength > 0 -> sideLength * sideLength
        else -> throw IllegalArgumentException("Side Length must be positive")
    }

/**
 * Calculate the area of a triangle
 *
 * @param base base of triangle
 * @param height height of triangle
 * @return area of given triangle
 */
fun areaOfATriangle(base: Double, height: Double) =
    when {
        base > 0 && height > 0 -> base * height / 2
        else -> throw IllegalArgumentException("Base and Height must be positive")
    }

/**
 * Calculate the area of a circle
 *
 * @param radius radius of circle
 * @return area of given circle
 */
fun areaOfACircle(radius: Double) =
    when {
        radius > 0 -> Math.PI * radius.pow(2.0)
        else -> throw IllegalArgumentException("Radius must be positive")
    }