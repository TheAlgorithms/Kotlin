package search

import org.junit.Test

class InterpolationSearchTest
{
    @Test
    fun testWhenElementPresent(){
        val array = intArrayOf(1,2,3,4,5)

        assert(interpolationSearch(array,0,array.size-1,5)==4)
    }

    @Test
    fun testWhenElementNotPresent() {
        val array = intArrayOf(4,7,9,23,67,78,99)

        assert(interpolationSearch(array,0,array.size-1,100)==-1)
    }
}