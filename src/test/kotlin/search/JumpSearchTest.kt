package search

import org.junit.Test

class JumpSearchTest {

    @Test
    fun testBinarySearch1() {
        val array = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
        val key = 55
        assert(jumpSearch(array, key) == 10)
    }

    @Test
    fun testBinarySearch2() {
        val array = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
        val key = 0
        assert(binarySearch(array, key) == 0)
    }

    @Test
    fun testBinarySearch3() {
        val array = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
        val key = 233
        assert(binarySearch(array, key) == 13)
    }

    @Test
    fun testBinarySearch4() {
        val array = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
        val key = 15
        assert(binarySearch(array, key) == -1)
    }

    @Test
    fun testBinarySearch5() {
        val array = arrayOf("A", "B", "D", "E")
        val key = "D"
        assert(binarySearch(array, key) == 2)
    }
}