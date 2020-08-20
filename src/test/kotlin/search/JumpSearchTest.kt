package search

import org.junit.Test

class JumpSearchTest {

    @Test
    fun testBinarySearch1() {
        val array = arrayOf(1, 2, 4, 8, 16)
        val key = 2
        assert(jumpSearch(array, key) == 1)
    }

    @Test
    fun testBinarySearch2() {
        val array = arrayOf(1, 2, 4, 8, 16)
        val key = 1
        assert(jumpSearch(array, key) == 0)
    }

    @Test
    fun testBinarySearch3() {
        val array = arrayOf(1, 2, 4, 8, 16)
        val key = 16
        assert(jumpSearch(array, key) == 4)
    }

    @Test
    fun testBinarySearch4() {
        val array = arrayOf(1, 2, 4, 8, 16)
        val key = 20
        assert(jumpSearch(array, key) == -1)
    }

    @Test
    fun testBinarySearch5() {
        val array = arrayOf("A", "B", "D", "E")
        val key = "D"
        assert(jumpSearch(array, key) == 2)
    }
}
