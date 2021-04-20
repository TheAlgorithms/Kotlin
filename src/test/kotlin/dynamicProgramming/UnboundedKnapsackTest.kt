package dynamicProgramming

import org.junit.Test

class UnboundedKnapsackTest {
    @Test
    fun testBothWeightAndValueArrayHasDifferentValuesGivesExpectedOutput() {
        assert(unboundedKnapsack(5, intArrayOf(1, 2, 3), intArrayOf(20, 50, 30), 3) == 120)
    }

    @Test
    fun testBothWeightAndValueArrayHasSameValuesGivesExpectedOutput() {
        assert(unboundedKnapsack(3, intArrayOf(2, 2), intArrayOf(3, 3), 2) == 3)
    }

    @Test
    fun testNegativeCapacityGivesZero() {
        assert(unboundedKnapsack(-3, intArrayOf(2, 2), intArrayOf(3, 3), 2) == 0)
    }

    @Test
    fun testZeroCapacityGivesZero() {
        assert(unboundedKnapsack(0, intArrayOf(2, 2), intArrayOf(3, 3), 2) == 0)
    }
}