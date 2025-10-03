/**
 * Returns true if the given number is prime, false otherwise.
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    println("7 is prime? ${isPrime(7)}")    // true
    println("10 is prime? ${isPrime(10)}")  // false
    println("13 is prime? ${isPrime(13)}")  // true
}
