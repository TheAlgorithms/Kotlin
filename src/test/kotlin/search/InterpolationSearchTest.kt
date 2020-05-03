package search

import org.junit.Test
import org.junit.Assert.*

class InterpolationSearchTest {
    val sortedArray = arrayOf(0, 3, 4, 7, 9, 12, 18, 23, 33, 40)

    @Test
    fun interpolationSearchFirstElement() {
        val index = interpolationSearch(sortedArray, 0)
        assertEquals(0, index)
    }

    @Test
    fun interpolationSearchLastElement() {
        val index = interpolationSearch(sortedArray, 40)
        assertEquals(9, index)
    }

    @Test
    fun interpolationSearchElement() {
        val index = interpolationSearch(sortedArray, 12)
        assertEquals(5, index)
    }

    @Test
    fun interpolationSearchMissingElement() {
        val index = interpolationSearch(sortedArray, 16)
        assertEquals(-1, index)
    }
}
