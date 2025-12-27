package sort

import org.junit.Assert
import org.junit.Test

class CycleSortTest {

    @Test
    fun `sort array of integers`() {
        val array = arrayOf(4, 3, 2, 8, 1)
        cycleSort(array)
        Assert.assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun `sort sorted array of integers`() {
        val array = arrayOf(1, 2, 3, 4, 8)
        cycleSort(array)
        Assert.assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun `sort array of characters`() {
        val array = arrayOf('A', 'D', 'E', 'C', 'B')
        cycleSort(array)
        Assert.assertArrayEquals(array, arrayOf('A', 'B', 'C', 'D', 'E'))
    }
}