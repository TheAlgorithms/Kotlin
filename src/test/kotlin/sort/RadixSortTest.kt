package sort

import org.junit.Assert.assertEquals
import org.junit.Test

class RadixSortTest {

    @Test
    fun `basicTest`() {
        val input = arrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        val n = input.size

        val expected = arrayOf(2, 24, 45, 66, 75, 90, 170, 802)
        radixSort(input, n)

        for (i in 0 until n) {
            assertEquals(expected[i], input[i])
        }
    }
}
