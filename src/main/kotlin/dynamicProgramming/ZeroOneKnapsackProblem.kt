package dynamicProgramming

import kotlin.math.max

/* This algorithm is Zero One Knapsack Problem

 * @param W- capacity, weight- array of weights, value- array of value, n- size of weight and value array
 * @return Maximum value that can be obtained
 */

fun zerooneknapsack(W:Int, weight: IntArray, values:IntArray, n:Int):Int{
    if (W<0) return 0
    val k = Array(n+1) {IntArray(W+1) {0} }
    for (i in 0..n)
    {
        for (j in 0..W)
        {
            if (i == 0 || j == 0)
                k[i][j] = 0
            else if (weight[i - 1] <= j)
                k[i][j] = max(values[i - 1]
            + k[i - 1][j - weight[i - 1]],
            k[i - 1][j])
            else
            k[i][j] = k[i - 1][j]
        }
    }
    return k[n][W]
}