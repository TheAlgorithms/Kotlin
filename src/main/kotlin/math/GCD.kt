package math

import kotlin.math.abs

/**
 * Returns the greatest common divisor of [number1] and [number2].
 *
 * See https://en.wikipedia.org/wiki/Greatest_common_divisor for more information.
 */
fun gcd(number1: Int, number2: Int): Int {
    require(number1 >= 0 || number1 >= 0)

    if (number1 == 0 || number2 == 0) {
        return abs(number1 - number2)
    }
    var num1 = number1
    var num2 = number2
    while (num1 % num2 != 0) {
        val remainder = num1 % num2
        num1 = num2
        num2 = remainder
    }
    return num2
}

/**
 * Returns the greatest common divisor of the [input].
 */
fun gcd(input: Array<Int>): Int {
    require(input.isNotEmpty())

    var result = input[0]
    for (i in 1 until input.size) {
        result = gcd(result, input[i])
    }
    return result
}
