package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class InsertionSortTest {

    @Test
    fun testInsertionSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        insertionSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testInsertionSort2() {
        val array = arrayOf(-1, 2, 43, 3, 97, 1, 0)
        insertionSort(array)

        assertArrayEquals(array, arrayOf(-1, 0, 1, 2, 3, 43, 97))
    }

    @Test
    fun testInsertionSort3() {
        val array = arrayOf("A", "D", "E", "C", "B")
        insertionSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}