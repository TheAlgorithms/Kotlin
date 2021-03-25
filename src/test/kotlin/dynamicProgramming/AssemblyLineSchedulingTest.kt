package dynamicProgramming

import org.junit.Test

class AssemblyLineSchedulingTest{

    @Test
    fun testWith6Stations() {
        assert(AssemblyLineScheduling(6,arrayOf(intArrayOf(3, 7, 2, 5,5,3), intArrayOf(4, 1, 6, 7,5,3)),arrayOf(intArrayOf(0,2,3,4,5,6), intArrayOf(0,5,4,3,2,1)), intArrayOf(15,11), intArrayOf(16,5))== 42)
    }
    @Test
    fun testWith2Stations() {
        assert(AssemblyLineScheduling(2,arrayOf(intArrayOf(3, 7), intArrayOf(4, 1)),arrayOf(intArrayOf(0,2), intArrayOf(0,5)), intArrayOf(5,1), intArrayOf(6,5))== 11)
    }
    @Test
    fun testWith4Stations() {
        assert(AssemblyLineScheduling(4,arrayOf(intArrayOf(3, 7,6,2), intArrayOf(4, 1,6,2)),arrayOf(intArrayOf(0,2,6,1), intArrayOf(0,5,3,4)), intArrayOf(7,4), intArrayOf(5,8))== 25)
    }


}
