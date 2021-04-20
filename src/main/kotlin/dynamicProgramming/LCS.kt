package dynamicProgramming

import kotlin.math.max

/* This algorithm is Longest Common Subsequence

 * @param  s1,s2 - strings to be compared
 * @return Length of longest common subsequence between two strings.
   Eg., for stage and sale it is 3.(sae is the longest common subsequence)
 */

fun lcs(s1: String, s2: String): Int {
    val L = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) L[i][j] = 0
            else if (s1[i - 1] == s2[j - 1]) L[i][j] = L[i - 1][j - 1] + 1
            else L[i][j] = max(L[i - 1][j], L[i][j - 1])
        }
    }
    return L[s1.length][s2.length]
}