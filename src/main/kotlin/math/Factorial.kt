package mathematics

import java.security.InvalidParameterException

/**
 * Calculates the factorial of a natural number greater than or equal to 0 recursively.
 * @param number The number of which to calculate the factorial.
 * @return The factorial of the number passed as parameter.
 */
fun getFactorial(number: Long): Long {
    if (number < 0L) {
        throw InvalidParameterException("The number of which to calculate the factorial must be greater or equal to zero.")
    } else return getFactorialOptimized(number, 1)
}

/**
 * Calculates the factorial using tail recursion to optimize code.
 * If the number is too high, the tail recursion returns 0.
 * @param number The number of which to calculate the factorial.
 * @param accumulator The accumulator of the factorial value
 * @return The factorial of the number passed as parameter.
 */
private tailrec fun getFactorialOptimized(number: Long, accumulator: Long): Long {
    return when (number) {
        0L -> accumulator
        else -> getFactorialOptimized(number - 1, number * accumulator)
    }
}