package dynamicProgramming

/*
 * This is a dynamic programming implementation of matrix chain multiplication.
 * @Params p- array which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]
 * @Return minimum number of multiplications needed to multiply the chain
 * */
fun matrixChainOrder(p: IntArray): Int {

    val m = Array(p.size) { IntArray(p.size) }
    var i: Int
    var j: Int
    var k: Int
    var l: Int
    var q: Int

    i = 1
    while (i < p.size) {
        m[i][i] = 0
        i++
    }

    l = 2
    while (l < p.size) {
        i = 1
        while (i < p.size - l + 1) {
            j = i + l - 1
            if (j == p.size) {
                i++
                continue
            }
            m[i][j] = Int.MAX_VALUE
            k = i
            while (k <= j - 1) {

                q = (m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j])
                if (q < m[i][j]) m[i][j] = q
                k++
            }
            i++
        }
        l++
    }
    return m[1][p.size - 1]
}