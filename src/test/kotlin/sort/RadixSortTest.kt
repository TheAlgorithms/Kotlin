package sort

import org.junit.Assert
import org.junit.Test

class RadixSortTest {

    @Test
    fun `sort array of integers`() {
        val array = arrayOf(123, 234, 98, 73, 119)
        radixSort(array)
        Assert.assertArrayEquals(array, arrayOf(73, 98, 119, 123, 234))
    }

    @Test
    fun `sorting empty array`() {
        val array = arrayOf<Int>()
        radixSort(array)
        Assert.assertArrayEquals(array, arrayOf())
    }

}