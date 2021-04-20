package dynamicProgramming

import kotlin.math.max

/*
 * This is a dynamic programming implementation of rod cutting problem.
 * @Params price- array of prices of all possible cut sizes of rod of array length
 * @Return maximum value obtained by cutting rod
 * */
fun rodCutting(price: IntArray): Int {
    val value = IntArray(price.size + 1)
    value[0] = 0

    for (i in 1..price.size) {
        var maxVal = Int.MIN_VALUE
        for (j in 0 until i) maxVal = max(maxVal,
                price[j] + value[i - j - 1])
        value[i] = maxVal
    }
    return value[price.size]
}