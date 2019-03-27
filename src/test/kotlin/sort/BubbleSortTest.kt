package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class BubbleSortTest {

    @Test
    fun testBubbleSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        bubbleSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testBubbleSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        bubbleSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}