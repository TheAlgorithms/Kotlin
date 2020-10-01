package dynamicProgramming

fun fibonacci(n: Int): Int {
    return fibonacciHelper(n, Pair(0, 1))
}

private tailrec fun fibonacciHelper(n: Int, pair: Pair<Int, Int>): Int {
    val a = pair.first
    val b = pair.second

    return when (n) {
        0 -> a
        1 -> b
        else -> fibonacciHelper(n - 1, Pair(b, a + b))
    }
}
