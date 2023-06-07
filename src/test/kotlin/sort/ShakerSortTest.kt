package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ShakerSortTest {

    @Test
    fun testShakeSort() {
        val array = arrayOf(4,3,2,8,1)
        shakerSort(array)
        assertArrayEquals(array, arrayOf(1,2,3,4,8))
    }

    @Test
    fun testShakeSort2() {
        val array = arrayOf(20, 5, 16, -1, 6)
        shakerSort(array)
        assertArrayEquals(array, arrayOf(-1, 5, 6, 16, 20))
    }

    @Test
    fun testShakeSort3() {
        val array = arrayOf("A", "D", "E", "C", "B")
        shakerSort(array)
        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}
