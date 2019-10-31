package math

import kotlin.math.abs

/**
 * find the closest number from x to between two given params comp1 or comp2.
 * for example, closestBetweenTwo(4,2,8) returns 2 as 2 is closer to 4 than 8 is.
 *
 * providing same distanced numbers will return larger number (e.g. closestBetweenTwo(4,2,6) = 6
 */
fun closestBetweenTwo(x: Int, comp1: Int, comp2: Int) : Int
        = if (abs(x - comp1) < abs(x - comp2)) comp1 else comp2