package search

import org.junit.Test

class LinearSearchTest {

    @Test
    fun testLinearSearch1() {
        val array = arrayOf(1, 2, 4, 5, 3, 9, 53)
        val key = 5

        assert(linearSearch(array, key) == 3)
    }

    @Test
    fun testLinearSearch2() {
        val array = arrayOf(1, 4, 3)
        val key = 9

        assert(linearSearch(array, key) == -1)
    }
}
