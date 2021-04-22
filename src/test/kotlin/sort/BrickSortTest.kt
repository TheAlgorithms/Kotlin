package sort

import org.junit.Assert
import org.junit.Test

class BrickSortTest{
    @Test
    fun testForIntegers(){
        val array = arrayOf(4, 3, 2, 8, 1)
        oddEvenSort(array)

        Assert.assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testForCharacters() {
        val array = arrayOf("A", "D", "E", "C", "B")
        bubbleSort(array)

        Assert.assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}