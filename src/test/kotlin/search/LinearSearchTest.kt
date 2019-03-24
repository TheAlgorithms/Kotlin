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

    @Test
    fun testLinearSearch3() {
        val array = arrayOf('a', 'c', 'e', 'd')
        val key = 'c'

        assert(linearSearch(array, key) == 1)
    }

    @Test
    fun testLinearSearch4() {
        val array = arrayOf("Hey", "There", "How", "Are", "You")
        val key = "You"

        assert(linearSearch(array, key) == 4)
    }
}
