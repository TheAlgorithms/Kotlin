package dynamicProgramming

/**
 * Extension function that checks if an integer is a prime number.
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * @return true if the number is prime, false otherwise
 */
fun Int.isPrime() = this > 1 && (2..(this / 2)).all { this % it != 0 }
