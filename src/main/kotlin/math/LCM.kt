/**
 * Computes the Least Common Multiple (LCM) of two integers.
 */
fun lcm(a: Int, b: Int): Int {
    return kotlin.math.abs(a * b) / gcd(a, b)
}

// Reusing gcd function from GCD.kt
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
    println("LCM of 12 and 18 is ${lcm(12, 18)}") // 36
    println("LCM of 5 and 7 is ${lcm(5, 7)}")     // 35
}
