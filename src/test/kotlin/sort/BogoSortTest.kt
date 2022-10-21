package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class BogoSortTest {

    @Test
    fun testBogoSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        bogoSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testBogoSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        bogoSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }

    @Test
    fun testBogoSort3() {
        val array = arrayOf(20, 5, 16, -1, 6)
        bogoSort(array)

        assertArrayEquals(array, arrayOf(-1, 5, 6, 16, 20))
    }

}
