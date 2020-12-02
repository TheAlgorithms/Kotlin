package math

import java.lang.Math.log10
import java.lang.Math.abs
import java.lang.Math.floor

/**
 * find the number of the digits
 *
 * @param number the number that we want to find the number of the digits
 * @return the number of the digits
 */

fun <T : Comparable<T>> numberOfTheDigits(number: Long): Int{
    return if (number === 0) 1 else floor(log10(abs(number).toDouble()) + 1).toInt()
}