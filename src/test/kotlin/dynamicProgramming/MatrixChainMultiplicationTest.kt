package dynamicProgramming

import org.junit.Test

class MatrixChainMultiplicationTest {
    @Test
    fun testWith5Matrices() {
        assert(MatrixChainOrder(intArrayOf(30, 20, 40, 10, 30)) == 23000)
    }

    @Test
    fun testWith4Matrices() {
        assert(MatrixChainOrder(intArrayOf(50, 20, 10, 30)) == 25000)
    }
}