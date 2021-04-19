package dynamicProgramming

import org.junit.Test

class ZeroOneKnapsackProblemTest {
    @Test
    fun testBothWeightAndValueArrayHasDifferentValuesGivesExpectedOutput() {
        assert(zerooneknapsack(5, intArrayOf(3,2,1), intArrayOf(20,50,30),3) == 80)
    }

    @Test
    fun testBothWeightAndValueArrayHasSameValuesGivesExpectedOutput(){
        assert(zerooneknapsack(3, intArrayOf(2,2), intArrayOf(3,3),2)==3)
    }

    @Test
    fun testNegativeCapacityGivesZero(){
        assert(zerooneknapsack(-3, intArrayOf(2,2), intArrayOf(3,3),2)==0)
    }

    @Test
    fun testZeroCapacityGivesZero(){
        assert(zerooneknapsack(0, intArrayOf(2,2), intArrayOf(3,3),2)==0)
    }
}