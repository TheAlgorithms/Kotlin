package math

import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * Calculate the perimeter of a rectangle
 *
 * @param length length of rectangle
 * @param width width of rectangle
 * @return perimeter of given rectangle
 */
fun perimeterOfARectangle(length: Double, width: Double) =  when {
    length > 0 && width > 0 -> 2 * (length + width)
    else -> throw IllegalArgumentException("Length and Width must be positive")
}

/**
 * Calculate the perimeter of a square
 *
 * @param sideLength side length of square
 * @return perimeter of given square
 */
fun perimeterOfASquare(sideLength: Double) =
    when {
        sideLength > 0 -> 4 * sideLength
        else -> throw IllegalArgumentException("Side Length must be positive")
    }

/**
 * Calculate the perimeter of a triangle
 *
 * @param base base of triangle
 * @param sideLength1 side length of triangle
 * @param sideLength2 other side length of triangle
 * @return perimeter of given triangle
 */
fun perimeterOfATriangle(base: Double, sideLength1: Double, sideLength2: Double) =
    when {
        base > 0 && sideLength1 > 0 && sideLength2 > 0 -> base + sideLength1 + sideLength2
        else -> throw IllegalArgumentException("Base and Sides of the triangle must be positive")
    }

/**
 * Calculate the perimeter of a circle
 *
 * @param radius radius of circle
 * @return perimeter of given circle
 */
fun perimeterOfACircle(radius: Double) =
    when {
        radius > 0 -> 2 * Math.PI * radius
        else -> throw IllegalArgumentException("Radius must be positive")
    }