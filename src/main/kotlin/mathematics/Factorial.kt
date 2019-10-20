package mathematics

import java.security.InvalidParameterException

/**
 * Calculates the factorial of a natural number grater than 0 recursively.
 * @param number The number of which to calculate the factorial.
 * @return The factorial of the number passed as parameter.
 */
fun getFactorial(number: Int): Int {
    if (number < 0) {
        throw InvalidParameterException("The number of which to calculate the factorial must be greater or equal to zero.")
    } else return if (number == 0) {
        1
    } else if (number == 1) {
        number
    } else {
        number * getFactorial(number - 1)
    }
}