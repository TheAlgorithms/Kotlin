package search

import org.junit.Test

class TernarySearchTest {
    companion object {
        const val EPS = 1e-2
    }

    @Test
    fun testTernarySearch1() {
        val func = { x: Double ->
            if (x < 10) {
                x
            } else {
                -10 * (x - 10) + 10
            }
        }
        assert(kotlin.math.abs(ternarySearch(-1e9, 1e9, func) - 10) <= EPS)
    }
}