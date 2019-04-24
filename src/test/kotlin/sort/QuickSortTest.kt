package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class QuickSortTest {

    @Test
    fun testQuickSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        quickSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testQuickSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        quickSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }

    @Test
    fun testQuickSort3() {
        val array = arrayOf(20, 5, 16, -1, 6)
        quickSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf(-1, 5, 6, 16, 20))
    }
}
