package dynamicProgramming

import kotlin.math.max

fun lcs(X: String, Y: String): Int {
    val L = Array(X.length + 1) { IntArray(Y.length + 1) }

    for (i in 0..X.length) {
        for (j in 0..Y.length) {
            if (i == 0 || j == 0) L[i][j] = 0
            else if (X[i - 1] == Y[j - 1]) L[i][j] = L[i - 1][j - 1] + 1
            else L[i][j] = max(L[i - 1][j], L[i][j - 1])
        }
    }
    return L[X.length][Y.length]
}