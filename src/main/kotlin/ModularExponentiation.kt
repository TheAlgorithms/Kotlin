fun modularExponentiation(base: Long, exponent: Long, mod: Long): Long {
    var result = 1L
    var b = base % mod
    var e = exponent
    while (e > 0) {
        if (e % 2 == 1L) {
            result = (result * b) % mod
        }
        b = (b * b) % mod
        e /= 2
    }
    return result
}

// Test main function
fun main() {
    println("3^13 % 7 = ${modularExponentiation(3, 13, 7)}")  // Output: 3
    println("5^117 % 19 = ${modularExponentiation(5, 117, 19)}") // Output: 1
}
