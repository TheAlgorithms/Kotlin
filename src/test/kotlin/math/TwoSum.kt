package math

import org.junit.Test

class TwoSumTest {
    @Test
    fun testTwoSum(){
        val array = IntArray(2)
        array[0] = 3
        array[1] = 3
        val target = 6
        val result = intArrayOf(0,1)
        assert(twoSum(array,target).contentEquals(result))
    }

    @Test
    fun testTwoSumOptimised(){
        val array = intArrayOf(1, 0, -1, 2, 4, 5, 3, 2)
        val target: Int = 4
        val result = twoSumOptimised(array, target).apply {
            this.all { it.first + it.second == target }
        }
        assert(result.isNotEmpty())
    }
}