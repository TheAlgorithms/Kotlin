/**
 * Returns the n-th Fibonacci number (0-based index) using iteration.
 */
fun fibonacci(n: Int): Long {
    require(n >= 0) { "n must be non-negative" }
    if (n == 0) return 0
    if (n == 1) return 1
    var a = 0L
    var b = 1L
    for (i in 2..n) {
        val temp = a + b
        a = b
        b = temp
    }
    return b
}

fun main() {
    println("Fibonacci(0) = ${fibonacci(0)}")   // 0
    println("Fibonacci(1) = ${fibonacci(1)}")   // 1
    println("Fibonacci(10) = ${fibonacci(10)}") // 55
}
