package dynamicProgramming

import org.junit.Test

class RodCuttingProblemTest {

    @Test
    fun testWithRodSize3() {
        assert(rodCutting(intArrayOf(3, 8, 10)) == 11)
    }

    @Test
    fun testWithZeroPrice() {
        assert(rodCutting(intArrayOf(0, 0, 0)) == 0)
    }

    @Test
    fun testWithSameValue() {
        assert(rodCutting(intArrayOf(2, 4, 6, 8, 10)) == 10)
    }

}