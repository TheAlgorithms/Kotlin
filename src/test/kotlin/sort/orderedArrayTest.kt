  
package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test
class OrderedArray {
     @Test
    fun testOrderedArray1() {
        val array = arrayOf("Abhi", "Suman", "Misty", "Rhea", "Mukesh", "Ramesh", "Sunny")
        bubbleSort(array)

        assertArrayEquals(array, arrayOf("Abhi", "Suman", "Misty", "Rhea", "Mukesh", "Ramesh", "Sunny"))
    }

    @Test
    fun testOrderedArray2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        bubbleSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}
