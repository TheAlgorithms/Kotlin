package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SelectionSortTest {

    @Test
    fun testSelectionSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        selectionSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testSelectionSort2() {
        val array = arrayOf(20, 5, 16, -1, 6)
        selectionSort(array)

        assertArrayEquals(array, arrayOf(-1, 5, 6, 16, 20))
    }

    @Test
    fun testSelectionSort3() {
        val array = arrayOf("A", "D", "E", "C", "B")
        selectionSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}