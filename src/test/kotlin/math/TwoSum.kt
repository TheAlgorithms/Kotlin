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
}