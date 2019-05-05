package search

import org.junit.Test

class IterativeBinarySearchTest {

    @Test
    fun testIterativeBinarySearch1() {
        val array = arrayOf(1, 2, 4, 8 , 16)
        val key = 2
        assert(iterativeBinarySearch(array, key) == 1)
    }

    @Test
    fun testBinarySearch2() {
        val array = arrayOf(1, 2, 4, 8 , 16)
        val key = 1
        assert(iterativeBinarySearch(array, key) == 0)
    }

    @Test
    fun testBinarySearch3() {
        val array = arrayOf(1, 2, 4, 8 , 16)
        val key = 16
        assert(iterativeBinarySearch(array, key) == 4)
    }

    @Test
    fun testBinarySearch4() {
        val array = arrayOf(1, 2, 4, 8 , 16)
        val key = 20
        assert(iterativeBinarySearch(array, key) == -1)
    }

    @Test
    fun testBinarySearch5() {
        val array = arrayOf("A", "B", "D", "E")
        val key = "D"
        assert(iterativeBinarySearch(array, key) == 2)
    }
}