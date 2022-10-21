package math

import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * Calculate the volume of a cuboid
 *
 * @param length length of cuboid
 * @param width width of cuboid
 * @param depth depth of cuboid
 * @return volume of given cuboid
 */
fun volumeOfACuboid(length: Double, width: Double, depth: Double) = 
    when {
    	length > 0 && width > 0 && depth > 0 -> length * width * depth
    	else -> throw IllegalArgumentException("Length, Width and Depth must be positive")
	}

/**
 * Calculate the volume of a cube
 *
 * @param sideLength side length of cube
 * @return volume of given cube
 */
fun volumeOfACube(sideLength: Double) =
    when {
        sideLength > 0 -> sideLength * sideLength * sideLength
        else -> throw IllegalArgumentException("Side Length must be positive")
    }

/**
 * Calculate the volume of a sphere
 *
 * @param radius radius of sphere
 * @return volume of given sphere
 */
fun volumeOfASphere(radius: Double) =
    when {
        radius > 0 -> (4.0 / 3.0) * Math.PI * radius.pow(3.0)
        else -> throw IllegalArgumentException("Radius must be positive")
    }