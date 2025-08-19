package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class CocktailSortTest {

    @Test
    fun testCocktailSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        cocktailSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testCocktailSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        cocktailSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}
