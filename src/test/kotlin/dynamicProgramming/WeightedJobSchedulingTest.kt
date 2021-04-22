package dynamicProgramming

import org.junit.Test

class WeightedJobSchedulingTest{
    @Test
    fun testForBasicCases(){
        assert(findMaxProfit(listOf(Job(0,1,30),Job(0,2,10),Job(0,3,50),Job(1,4,60),Job(2,3,120),Job(2,5,90),Job(3,6,40),Job(4,7,70)))==220)
    }

    @Test
    fun testForSameOptimalOutput(){
        assert(findMaxProfit(listOf(Job(0,2,10),Job(1,3,10)))==10)
    }
}
