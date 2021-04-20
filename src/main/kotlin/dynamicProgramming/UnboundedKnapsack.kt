package dynamicProgramming

import kotlin.math.max

/* This algorithm is Unbounded Knapsack Problem

 * @param W- capacity, weight- array of weights, value- array of value, n- size of weight and value array
 * @return Maximum value with repetition of items that can be obtained
 */

fun unboundedKnapsack(W: Int, wt: IntArray, v: IntArray, n: Int): Int {

    if (W < 0) return 0

    val dp = IntArray(W + 1)

    for (i in 0..W) {
        for (j in 0 until n) {
            if (wt[j] <= i) {
                dp[i] = max(dp[i], dp[i - wt[j]] + v[j])
            }
        }
    }

    for (i in 0..W) {
        print(dp[i])
        print(" ")
    }
    println(dp[W])
    return dp[W]
}