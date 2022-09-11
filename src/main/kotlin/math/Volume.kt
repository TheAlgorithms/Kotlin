package math

import kotlin.math.pow

/**
 * Calculate the volume of a cube
 *
 * @param length of a cube
 * @return volume of given cube
 */
fun cubeVolume(length: Double) = when {
    length > 0 -> length * length * length
    else -> throw IllegalArgumentException("Length must be positive")
}

/**
 * Calculate volume of a rectangular prism
 *
 * @param length of rectangular prism
 * @param width of rectangular prism
 * @param height of rectangular prism
 * @return volume of given rectangular prism
 */
fun rectPrismVolume(length: Double, width: Double, height: Double) = when {
    length > 0 && width > 0 && height > 0 -> length * width * height
    else -> throw IllegalArgumentException("Length, Width and Height must be positive")
}

/**
 * Calculate volume of a triangle prism
 *
 * @param base of triangle prism
 * @param height of triangle prism
 * @param depth of triangle prism
 * @return volume of given triangle prism
 */
fun trianglePrismVolume(base: Double, height: Double, depth: Double) = when {
    base > 0 && height > 0 && depth > 0 -> base * height * depth / 2
    else -> throw IllegalArgumentException("Base, Height, Depth must be positive")
}

/**
 * Calculate volume of a cone
 *
 * @param radius of cone
 * @param height of cone
 * @param PI (optional) default to 3.14
 * @return volume of given cone
 */
fun coneVolume(radius: Double, height: Double, PI: Double = 3.14) = when {
    radius > 0 && height > 0 && PI > 0 -> radius.pow(2) * PI * height / 3
    else -> throw IllegalArgumentException("Radius and Height must be positive")
}

/**
 * Calculate volume of a pyramid
 *
 * @param length of pyramid
 * @param width of pyramid
 * @param height of pyramid
 * @return volume of given pyramid
 */
fun pyramidVolume(length: Double, width: Double, height: Double) = when {
    length > 0 && width > 0 && height > 0 -> length * width * height / 3
    else -> throw IllegalArgumentException("Length, Width and Height must be positive")
}

/**
 * Calculate volume of a sphere
 *
 * @param radius of sphere
 * @param PI (optional) default to 3.14
 * @return volume of given sphere
 */
fun sphereVolume(radius: Double, PI: Double = 3.14) = when {
    radius > 0 && PI > 0 -> PI * radius.pow(3) * 4 / 3
    else -> throw IllegalArgumentException("Radius must be positive")
}

/**
 * Calculate volume of a cylinder
 *
 * @param radius of cylinder
 * @param height of cylinder
 * @param PI (optional) default to 3.14
 * @return volume of given cylinder
 */
fun cylinderVolume(radius: Double, height: Double, PI: Double = 3.14) = when {
    radius > 0 && height > 0 && PI > 0 -> PI * radius.pow(2) * height
    else -> throw IllegalArgumentException("Radius and Height must be positive")
}