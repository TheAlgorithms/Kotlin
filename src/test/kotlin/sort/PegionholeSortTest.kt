package sort

import org.junit.Assert
import org.junit.Test

class PegionholeSortTest {

    @Test
    fun testPegionholeSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        pegionholeSort(array, array.size)

        Assert.assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testPegionholeSort2() {
        val array = arrayOf("-18,-2,12,23,4,2,6,1,0,-7,77)
        pegionholeSort(array, array.size)

        Assert.assertArrayEquals(array, arrayOf(-18, -7, -2, 0, 1, 2, 4, 6, 12, 23, 77))
    }

    @Test
    fun testPegionholeSort3() {
        val array = arrayOf(20, 5, 16, -1)
        pegionholeSort(array, array.size)

        Assert.assertArrayEquals(array, arrayOf(-1, 5, 16, 20))
    }
}
