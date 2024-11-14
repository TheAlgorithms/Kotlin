package dynamicProgramming

/**
 * The following example is taken from Ken Kousen book "Kotlin Cookbook. A Problem-Focused Approach"
 */

/**
 * Get Fibonacci sequence
 */
fun fibonacciSequence() = sequence {
    var terms = Pair(0, 1)
    while (true) {
        yield(terms.first)
        terms = terms.second to terms.first + terms.second
    }
}


/**
 * Get n Fibonacci number
 */
fun fibonacciFold(n: Int) =
    (2 until n).fold(1 to 1) { (prev, curr), _ ->
        curr to (prev + curr) }.second

/**
 * Get n Fibonacci number
 */
@JvmOverloads
tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
    when (n) { 0 -> a 1 -> b
        else -> fibonacci(n - 1, b, a + b) }