package dynamicProgramming

/***
 * This method use recursive way to find nth fibonacci
 *
 * @param n nth number in fibonacci series.
 *
 * <b>Time Complexity</b>: T(n) = T(n-1) + T(n-2) which is exponential.
 */
fun fibonacci_recursion(n: Int): Long {
    if (n <= 1)
        return n.toLong()
    return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2)
}

/***
 * This method use ArrayList to store Fibonacci numbers calculated
 *
 * @param n nth number in fibonacci series.
 *
 * We can avoid the repeated work done is method 1 by storing the Fibonacci numbers calculated so far.
 *
 */
fun fibonacci_dynamic(n: Int): Long {
    val g = LongArray(n+2)

    g[0] = 0
    g[1] = 1

    for (i in 2..n) {
        g[i] = g[i -1] + g[i-2]
    }
    return g[n]
}

/***
 * This method we optimized the space used in method 2 fibonacciDynamic()
 * by storing the previous two numbers only because that is all we need to get the next Fibonacci number in series.
 *
 * <b>Time Complexity</b>: O(n) ,
 * <b>Extra Space</b>: O(1)
 *
 * @see fibonacci_dynamic
 * @param n nth number in fibonacci series.
 */
fun fibonacci_dynamic_optimized(n: Int): Long {
    var a: Long = 0
    var b: Long = 1
    var c: Long = 0

    if (n == 0)
        return 0
    for (i in 2..n) {
        c = a + b;
        a = b;
        b = c;
    }

    return b

}

/***
 * This method use matrix to solve nth number fibonacci
 *
 * <b>Time Complexity</b>: O(n) ,
 * <b>Extra Space</b>: O(1)
 *
 * @param n nth number in fibonacci series.
 */
fun fibonacci_matrix(n: Int): Long {
    val f = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    if (n == 0)
        return 0
    power(f, n - 1)
    return f[0][0]
}
/**
 * Helper function that calculates F[][] raise to the power n and puts the
result in F[][]
Note that this function is designed only for fib() and won't work as general
power function
 */
private fun power(F: Array<LongArray>, n: Int) {
    var i: Long
    val M = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

    // n - 1 times multiply the matrix to {{1,0},{0,1}}
    i = 2
    while (i <= n) {
        multiply(F, M)
        i++
    }
}
/***
 *  Helper function that multiplies 2 matrices F and M of size 2*2, and puts the multiplication result back to F[][]
 */
private fun multiply(F: Array<LongArray>, M: Array<LongArray>) {
    val x = F[0][0] * M[0][0] + F[0][1] * M[1][0]
    val y = F[0][0] * M[0][1] + F[0][1] * M[1][1]
    val z = F[1][0] * M[0][0] + F[1][1] * M[1][0]
    val w = F[1][0] * M[0][1] + F[1][1] * M[1][1]

    F[0][0] = x
    F[0][1] = y
    F[1][0] = z
    F[1][1] = w
}

/***
 * This method we optimized time complexity fibonacci_matrix()
 *
 * <b>Time Complexity</b>: O(Logn)
 * <b>Extra Space</b>: O(Logn) if we consider the function call stack size, otherwise O(1).
 *
 * @see fibonacci_matrix
 * @param n nth number in fibonacci series.
 */
fun fibonacci_matrix_optimized(n: Int): Long {
    val F = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    if (n == 0)
        return 0
    power2(F, n - 1)

    return F[0][0]
}
private fun multiply2(F: Array<LongArray>, M: Array<LongArray>) {
    val x = F[0][0] * M[0][0] + F[0][1] * M[1][0]
    val y = F[0][0] * M[0][1] + F[0][1] * M[1][1]
    val z = F[1][0] * M[0][0] + F[1][1] * M[1][0]
    val w = F[1][0] * M[0][1] + F[1][1] * M[1][1]

    F[0][0] = x
    F[0][1] = y
    F[1][0] = z
    F[1][1] = w
}
/***
 * Optimized version of power()
 *
 * @see power
 */
private fun power2(F: Array<LongArray>, n: Int) {
    if (n == 0 || n == 1)
        return
    val M = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

    power2(F, n / 2)
    multiply2(F, F)

    if (n % 2 != 0)
        multiply2(F, M)
}

/***
 * This method we directly implement the formula for nth term in the fibonacci series.
 *
 * formula ={Fn = {[(√5 + 1)/2] ^ n} / √5}
 *
 * <b>Time Complexity</b>: O(1) ,
 * <b>Extra Space</b>: O(1)
 *
 * Reference: http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
 *
 * @param n nth number in fibonacci series.
 */
fun fibonacci_formula(n: Int):Long{
    val phi = (1 + Math.sqrt(5.0)) / 2
    return Math.round(Math.pow(phi, n.toDouble()) / Math.sqrt(5.0))
}