/**
 * Computes the Greatest Common Divisor (GCD) of two integers using Euclid's algorithm.
 */
fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }
    return kotlin.math.abs(x)
}

fun main() {
    println("GCD of 12 and 18 is ${gcd(12, 18)}") // 6
    println("GCD of 7 and 3 is ${gcd(7, 3)}")     // 1
}
